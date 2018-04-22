package net.greatsoft.main.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.exam.HealthExamDrug;

import org.greenrobot.greendao.database.StandardDatabase;


/**
 * Created by zhanglin on 16/9/26.
 */

public class DevOpenHelper extends DaoMaster.OpenHelper {

    Context mContext;

    public DevOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
        mContext = context;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");

//        dropAllTables(db, true);

        if (oldVersion < 102) {

            Log.e("database", "hasUpdate");
            /**
             * 儿童相关
             */
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildHealthExamDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildHomeVisitDao.class);
            /**
             * 妇女相关
             */
            MigrationHelper.migrate(new StandardDatabase(db),
                    MaternalFirstFollowupDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    MaternalFollowupDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    MaternalPostpartumFollowupDao.class);
        }
        /**
         * 字典相关
         */
        if (oldVersion < 103)
            MigrationHelper.migrate(new StandardDatabase(db),
                    DictsDao.class);
        if (oldVersion < 104) {
            MigrationHelper.migrate(new StandardDatabase(db),
                    TermDao.class);
        }
        /**
         * 妇女相关
         */
        if (oldVersion < 105) {
            MigrationHelper.migrate(new StandardDatabase(db),
                    MaternalChildbirthDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    MaternalNewbornSituationDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    MaternalRegisterDao.class);
        }
        if (oldVersion < 106) {
            /**
             * 肺结核相关
             */
            MigrationHelper.migrate(new StandardDatabase(db),
                    TuberculosisFirstFollowupDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    TuberculosisFollowupDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    TuberculosisInfoDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    TuberculosisReferralDao.class);
            /**
             * 疫苗相关
             */
            MigrationHelper.migrate(new StandardDatabase(db),
                    CdcVaccreportDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    CdcVaccreportAdverseDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    CdcVaccreportVaccinateDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    OrgChoiceVaccineDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    VaccineDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    VaccineBatchnoDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    VaccineInjectTimesDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    VaccineManufacturerDao.class);
        }
        /**
         * 儿童相关
         */
        if (oldVersion < 107) {
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildDeathDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildDiseaseScreenDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildDiseaseScreenDiagDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildDiseaseScreenResultDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildHearScreenDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildInfoDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildLedgerDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildPerinatalDeathDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildTcmLedgerDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildWeakFollowupDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildWeakInfoDao.class);
        }

        if(oldVersion <108){
            MigrationHelper.migrate(new StandardDatabase(db),
                    AndroidFileRecordDao.class);
        }

        if(oldVersion<109){
            MigrationHelper.migrate(new StandardDatabase(db),
                    SickMedicineDao.class);
        }

        if(oldVersion<110){
            MigrationHelper.migrate(new StandardDatabase(db),
                    DiabetesFollowupDao.class);
        }

        if(oldVersion<111){
            MigrationHelper.migrate(new StandardDatabase(db),
                    ChildInfoDao.class);
        }

        if(oldVersion<112){
            MigrationHelper.migrate(new StandardDatabase(db),
                    CerebralApoplexyInfoDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    CerebralApoplexyFollowupDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    CoronaryHeartDiseaseInfoDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    CoronaryHeartDiseaseFollowupDao.class);
        }
        if (oldVersion < 113) {
            MigrationHelper.migrate(new StandardDatabase(db),
                    SickMedicineDao.class);
        }
        if (oldVersion < 114) {
            MigrationHelper.migrate(new StandardDatabase(db),
                    HyperFollowupDrugDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    DiabetesFollowupDrugDao.class);
            MigrationHelper.migrate(new StandardDatabase(db),
                    SmiFollowupDrugDao.class);
        }

        if(oldVersion < 115){
            MigrationHelper.migrate(new StandardDatabase(db),
                    HealthExamDao.class);
        }

    }
}
