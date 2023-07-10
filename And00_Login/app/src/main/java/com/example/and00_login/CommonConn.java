package com.example.and00_login;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn {
    private final String TAG = "CommonConn";

    private MbjCallBack callBack;
    private ProgressDialog dialog;
    // Retrofit을 매번 새로 인스턴스화 해서 사용 하는게 아닌 재 사용이 가능한 구조를 하나 만들어서 사용 하기
    private HashMap<String, Object> paramMap; // 파라미터 전송용
    private Context context; // 화면 위에 토스트, ProgressDialog를 보여 주기 위한 용도
    private String mapping; // mapping 받아 오기용

    public CommonConn(Context context, String mapping) {
        this.context = context;
        this.mapping = mapping;
        this.paramMap = new HashMap<>();
        Log.d("확인용", "onCreate: " + callBack);
    }

    public void addParamMap(String key, Object value) {
        if (key == null) {
            Log.e(TAG, "키값이 null ");
        } else if (value == null) {
            Log.e(TAG, "밸류값이 null // 경우에 따라 커스텀");
        } else {
            paramMap.put(key, value);
        }
    }

    //enque( 전송 실행 전 해야 할 코드를 넣어 줄 메소드 구현, ProgressDialog보이게 처리)
    private void onPreExcute() {
        if(context != null && dialog == null) {
            dialog = new ProgressDialog(context);
            dialog.setProgress(ProgressDialog.STYLE_SPINNER);
            dialog.setTitle("타이틀 확인용");
            dialog.setMessage("메시지 확인용");
            dialog.setCancelable(false);
            dialog.show();
        }
    }
    //enque가 실제로 되어야 하는 부분(파라미터 등을 이용해 실제로 Spring에 전송)
    public void onExcute(MbjCallBack callBack) {
        onPreExcute();
        // 2.
        Log.d("확인용", "onCreate: " + this.callBack);
        this.callBack= callBack;
        Log.d("확인용", "onCreate: " +this.callBack+" 받아온 것 =>" +callBack);
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        api.clientPostMethod(mapping,paramMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onExcute . onResponse: " + response.body());
                onPostExcute(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onExcute . onFailure: " + t.getMessage());
                onPostExcute(false, null);
            }
        });
    }

    private void onPostExcute(boolean isResult, String data){
        if(dialog!=null) {
            dialog.dismiss();
        }
        // 3.
        callBack.onResult(isResult, data);
    }

    // 옵저버 패턴, 감시 하다가 어떤 작업이 끝나면 특정 메소드를 실행
    // 1.
    public interface MbjCallBack{
        public void onResult(boolean isResult, String data);
    }

}
