package com.example.project02_lastproject.file;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.RetrofitClient;
import com.example.project02_lastproject.common.RetrofitInterface;
import com.example.project02_lastproject.databinding.ActivityFileBinding;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileActivity extends AppCompatActivity {
    ActivityFileBinding binding;

    private final int REQ_GALLERY = 1000;

    ActivityResultLauncher<Intent> launcher; // onCreate에서 초기화 하면 오류 발생


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Glide.with(this).load("http://   ip  /middle/img/andimg.jpg").into(binding.imgv);
        binding.imgv.setOnClickListener(v -> {
            showDialog();
        });
    }

    public void showDialog(){
        String[] dialog_item = {"갤러리", "카메라"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("사진 업로드 방식");
        builder.setSingleChoiceItems(dialog_item, -1, (dialog, i) -> {
            if(dialog_item[i].equals("갤러리")){
                //갤러리 로직
                showGallery();
            }else if(dialog_item[i].equals("카메라")){
                //카메라 로직
                showCamera();
            }
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
//        startActivity(intent); //단순 실행 결과를 알수가없다.
        startActivityForResult(intent, REQ_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ_GALLERY && resultCode ==RESULT_OK){
            //갤러리 액티비티가 종료되었다. (사용자가 사진을 선택했는지?)
            Log.d("갤러리", "onActivityResult: "+data.getData());
            Log.d("갤러리", "onActivityResult: "+data.getData().getPath());
            Glide.with(this).load(data.getData()).into(binding.imgv);//갤러리 이미지가 잘붙는지?
            String img_path = getRealPath(data.getData());

            //MultiPart 형태로 전송 (File)
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(img_path));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
            RetrofitInterface api = new RetrofitClient().retrofitLogin().create(RetrofitInterface.class);
            api.clientSendFile("file.f", new HashMap<>(), filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });

            //MultiPart <- Spring 처리 (RequestMapping(Controller))가 MultiPart를 받으려면 어떻게 했을까?
            //form태그 : 태그 사이에 있는 모든 입력 양식을 감싸는 태그로, name, action...등의 속성을 가지고 전송용 태그.
            //encType : 폼데이터 ↑ 서버로 전송될때 "파일을 담고 있다면" 데이터의 인코딩 과정이 필요하다.
            //multipart/form-data <-파일과 데이터는 담겨지는 영역이 다르기 때문에 여러부분(Multi)Body(Part)
        }
    }

    public String getRealPath(Uri contentUri){
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};//
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Cursor cursor = getContentResolver().query(contentUri, proj, null, null);
            if(cursor.moveToFirst()){
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                res = cursor.getString(column_index);
            }
            cursor.close();//다썼으니까 닫음.
        }
        Log.d("TAG", "getRealPath: 커서"+res);
        return res;
    }

    @Override
    protected void onStart() {
        super.onStart();
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                // 액티비티(카메라)가 종료 되면 콜백으로 데이터를 받는 부분 기존(onActivityResult메소드)가 실행 되었고 현재는 해당 메소드
                Glide.with(FileActivity.this).load(camera_uri).into(binding.imgv);
                File file = new File(getRealPath(camera_uri));
                if(file!= null) {
                    Toast.makeText(FileActivity.this, "카메라 확인용", Toast.LENGTH_SHORT).show();

                    RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
                    MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
                    RetrofitInterface api = new RetrofitClient().retrofitLogin().create(RetrofitInterface.class);
                    api.clientSendFile("file.f", new HashMap<>(), filePart).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                }

            }
        });
    }

    Uri camera_uri = null; // 사진 uri
    public void showCamera() {
        //ContentReseolver(). 앱 --> 컨텐트 리졸버(작업자) ---> 미디어 저장소
        camera_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, camera_uri);
        launcher.launch(cameraIntent);
    }
}