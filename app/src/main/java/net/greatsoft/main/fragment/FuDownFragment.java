package net.greatsoft.main.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.helper.DaoMaster;
import net.greatsoft.main.db.helper.DaoSession;
import net.greatsoft.main.db.helper.VisitDetailDao;
import net.greatsoft.main.db.po.VisitDetail;
import net.greatsoft.main.uiframe.FuDownView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhanglin on 16/8/3.\
 *  地区选择
 */
public class FuDownFragment extends FragmentParent {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_DOWN, getActivity(),
                new OnEventClick());

        return mModel.getFuView();
    }

    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

    }

    @Override
    protected void netErrorChild(int taskId, String msg) {

    }

    @Override
    protected void cancelChild(int taskId) {

    }
    public static final int EVENT_DOWN = 1;//测试下载
    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {

            switch (event) {
                case EVENT_DOWN:
//                    downFile();
                   openDatabase();

                    break;
            }

        }

    }

    private static final int HANDLER_PROCESS = 1;
    private static final int HANDLER_ERROR = 2;
    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what){
                case HANDLER_PROCESS:
                    break;
                case HANDLER_ERROR:
                    ((FuDownView)mModel).setError();
                    break;
            }
        }
    };

    SQLiteDatabase db;
    private final String DATABASE_PATH = android.os.Environment
            .getExternalStorageDirectory().getAbsolutePath() + "/chss";
    private String DATABASE_FILENAME = "db_vote.db";


    // 初始化数据库
    private SQLiteDatabase openDatabase() {
        try {
            String databaseFilename = DATABASE_PATH + "/" + DATABASE_FILENAME;
            File dir = new File(DATABASE_PATH);

            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getContext(), databaseFilename, null);


            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            DaoSession daoSession = daoMaster.newSession();
            VisitDetailDao detailDao = daoSession.getVisitDetailDao();
            List<VisitDetail> list_visitDetail = detailDao.loadAll();
            Log.e("tag",list_visitDetail.size()+"");

//            db = SQLiteDatabase.openOrCreateDatabase(databaseFilename, null);
//            Cursor c = db.rawQuery("select *from AndroidPersonInfo",null);
//            while (c.moveToNext()) {
//                PersonInfo pi = new PersonInfo();
//                pi.setAddress(c.getString(c.getColumnIndex("address")));
//            }
//            if (db.isOpen()) {
//                db.close();
//            }
            return db;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void downFile(){

        Request request = new Request.Builder().url("http://pic1.win4000.com/wallpaper/a/53e03d124c076.jpg").build();
       OkHttpClient mOkHttpClient = new OkHttpClient();
        mOkHttpClient.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                String SDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                try {
                    is = response.body().byteStream();
                    long total = response.body().contentLength();
                    File file = new File(SDPath, "test.log");
                    fos = new FileOutputStream(file);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        Log.d("h_bl", "progress=" + progress);
                        Message msg = mHandler.obtainMessage();
                        msg.what = HANDLER_PROCESS;
                        msg.arg1 = progress;
                        msg.obj = progress;
                        mHandler.sendMessage(msg);
                    }
                    fos.flush();
                    Log.d("h_bl", "文件下载成功");
                } catch (Exception e) {
                    Log.d("h_bl", "文件下载失败");
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("h_bl", "onFailure");
                Message msg = mHandler.obtainMessage();
                msg.what = HANDLER_ERROR;
                mHandler.sendMessage(msg);
            }


        });
    }

}
