package com.example.project02_lastproject.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.example.project02_lastproject.MainActivity;
import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.common.CommonVar;
import com.example.project02_lastproject.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {

// login?id=dev1&pw=dev1

    ActivityLoginBinding binding;

    SharedPreferences pref; //자바 변수가 static 등의 멤버로 데이터를 저장하면 앱을 다시 실행시 처음부터 불러옴. (DB)
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(v -> {
            login();
        });

        NaverIdLoginSDK.INSTANCE.initialize(this, "1hQH17C7HHOtXvellSdX", "4_i1kTt4zM", getString(R.string.app_name));
        naverLogin();

        KakaoSdk.init(this, "faf601ce16c809ff700bf54d00c05061");
        UserApiClient.getInstance().unlink(new Function1<Throwable, Unit>() {
            @Override
            public Unit invoke(Throwable throwable) {
                return null;
            }
        });

        binding.btnLoginKakao.setOnClickListener(v -> {
            kakaoLogin(this);
        });

        pref = getPreferences(MODE_PRIVATE);
        editor = pref.edit(); //데이터를 넣거나 수정하기위한 객체

        pref.getInt("permission", -1);

        //최초 실행 시 숫자, -1
        //한번 실행 후 -> ?
        //두번 실행 후 -> ?
        //거절 ->
        //승인 ->

        if (pref.getInt("permission", -1) == -1) {
            checkPermission();
        }


    }


    public void login() {
        if (binding.edtId.getText().toString().length() < 1 || binding.edtPw.getText().toString().length() < 1) {
            Toast.makeText(this, "아이디, 비밀번호 입력 안함", Toast.LENGTH_SHORT).show();
            return;
        }
        CommonConn conn = new CommonConn("login", this);
        conn.addParamMap("id", binding.edtId.getText().toString());
        conn.addParamMap("pw", binding.edtPw.getText().toString());
        conn.onExcute((isResult, data) -> {
            if (isResult) {
                CommonVar.loginInfo = new Gson().fromJson(data, AndMembersVO.class);
                if (CommonVar.loginInfo == null) {
                    Toast.makeText(this, "아이디 또는 비밀번호 확인", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void kakaoLogin(Context context) {
        KakaoSdk.init(this, "faf601ce16c809ff700bf54d00c05061");
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인(웹뷰)
        // Kotlin은 경우에 따라서 생성자 대신에 메소드로 객체를 return받음. UserApiClient name = new ... x -> UserApiClient.{static UserApiClient.method}

        Function2<OAuthToken, Throwable, Unit> callback = (token, error) -> {
            if (error != null) {
                Log.e("카카오 로그인 에러", "invoke: " + error.getMessage());
            } else {
                Log.d("카카오 로그인 성공", "invoke: " + token.toString());
                getKakaoProfile();
            }
            return null;
        };

        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(context)) {
            Log.d("카카오", "isKakaoTalkLoginAvailable: true");
            UserApiClient.getInstance().loginWithKakaoTalk(context, callback);
        } else {
            Log.d("카카오", "isKakaoTalkLoginAvailable: false");
            UserApiClient.getInstance().loginWithKakaoAccount(context, callback);
        }
    }

    public void getKakaoProfile() {
        UserApiClient.getInstance().me((user, error) -> {
            if (error == null) {
                Log.d("카카오", "getKakaoProfile: " + user.toString());
                Log.d("카카오", "getKakaoProfile: " + user.getKakaoAccount().getEmail());
                Log.d("카카오", "getKakaoProfile: " + user.getKakaoAccount().getProfile().getNickname());
                Log.d("카카오", "getKakaoProfile: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());
            }
            return null;
        });
    }

    public void naverLogin() {
        binding.btnLoginNaver.setOAuthLogin(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d("네이버", "onSuccess: " + NaverIdLoginSDK.INSTANCE.getAccessToken());
                new NidOAuthLogin().callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                    @Override
                    public void onSuccess(NidProfileResponse res) {
                        Log.d("네이버", "onSuccess: " + res.getProfile().getEmail());
                        Log.d("네이버", "onSuccess: " + res.getProfile().getNickname());
                    }

                    @Override
                    public void onFailure(int i, @NonNull String s) {

                    }

                    @Override
                    public void onError(int i, @NonNull String s) {

                    }
                });
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("네이버", "onFailure: ");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("네이버", "onError: ");
            }
        });
    }


    public static String getKeyHash(final Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            if (packageInfo == null)
                return null;

            for (Signature signature : packageInfo.signatures) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    return android.util.Base64.encodeToString(md.digest(), android.util.Base64.NO_WRAP);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private final int REQ_PERMISSION = 1000;
    private final int REQ_PERMISSION_DENY = 1001;

    private void checkPermission() {
        int permission = pref.getInt("permission", -1);
        permission++;
        editor.putInt("permission", permission);
        editor.apply();
        String[] permissions = {Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };//카메라 권한을 스트링으로 가져옴.
        // ContextCompat(액티비티가 아닌 곳), ActivityCompat(액티비티)
        for (int i = 0; i < permissions.length; i++) {
            //내가 모든 권한이 필요하다면 전체 권한을 하나씩 체크해서 허용 안됨이 있는 경우 다시 요청을 하게 만든다.
            if (ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_DENIED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])) {
                    //최초 앱이 설치되고 실행 시 false가 나옴. => 사용자가 거부 후 true 제거부 => false
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("권한 요청").setMessage("권한이 반드시 필요합니다. \n미허용 시 앱 사용 불가");
                    builder.setPositiveButton("확인(권한 허용)", (dialog, which) -> {
                        //2번 권한 설명 후 다시보여줌.
                        ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION_DENY);
                    });
                    builder.setNegativeButton("종료(권한 허용 불가)", (dialog, which) -> {
                        finish();
                    });

                    builder.create().show(); //<==넣어줘야함
                } else {
                    //1번
                    ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION);
                }
            }
            break;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (REQ_PERMISSION == requestCode) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    //거절된 권한이 있음.
                    checkPermission();
                    break;
                }
            }
            Log.d("권한", "onRequestPermissionsResult: 권한 요청 완료");
        } else if (REQ_PERMISSION_DENY == requestCode) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    Log.d("권한", "onRequestPermissionsResult: 다시 권한요청 화면을 띄울 수가 없음. 2회 거절당함");
                    editor.putInt("permission", -2);
                    //3번
                    viewSetting();
//                    checkPermission();
                }
            }
        }
    }

    public void viewSetting() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
        startActivity(intent);
    }
}