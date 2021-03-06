package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.vaccine.CdcVaccreportVaccinate;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CDC_VACCREPORT_VACCINATE".
*/
public class CdcVaccreportVaccinateDao extends AbstractDao<CdcVaccreportVaccinate, Void> {

    public static final String TABLENAME = "CDC_VACCREPORT_VACCINATE";

    /**
     * Properties of entity CdcVaccreportVaccinate.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property CdcVaccreportVaccinateId = new Property(0, String.class, "cdcVaccreportVaccinateId", false, "CDC_VACCREPORT_VACCINATE_ID");
        public final static Property PersonInfoId = new Property(1, String.class, "personInfoId", false, "PERSON_INFO_ID");
        public final static Property CdcVaccreportId = new Property(2, String.class, "cdcVaccreportId", false, "CDC_VACCREPORT_ID");
        public final static Property CdcVaccreportVaccinateNo = new Property(3, String.class, "cdcVaccreportVaccinateNo", false, "CDC_VACCREPORT_VACCINATE_NO");
        public final static Property VaccineId = new Property(4, String.class, "vaccineId", false, "VACCINE_ID");
        public final static Property VaccineName = new Property(5, String.class, "vaccineName", false, "VACCINE_NAME");
        public final static Property VaccinatePlanDate = new Property(6, java.util.Date.class, "vaccinatePlanDate", false, "VACCINATE_PLAN_DATE");
        public final static Property VaccinateDate = new Property(7, java.util.Date.class, "vaccinateDate", false, "VACCINATE_DATE");
        public final static Property VaccinateSiteCode = new Property(8, String.class, "vaccinateSiteCode", false, "VACCINATE_SITE_CODE");
        public final static Property VaccinateSiteValue = new Property(9, String.class, "vaccinateSiteValue", false, "VACCINATE_SITE_VALUE");
        public final static Property VaccineBatchNo = new Property(10, String.class, "vaccineBatchNo", false, "VACCINE_BATCH_NO");
        public final static Property InjectTimesId = new Property(11, String.class, "injectTimesId", false, "INJECT_TIMES_ID");
        public final static Property VaccinateDoses = new Property(12, Integer.class, "vaccinateDoses", false, "VACCINATE_DOSES");
        public final static Property Measure = new Property(13, String.class, "measure", false, "MEASURE");
        public final static Property ManufacturerId = new Property(14, String.class, "manufacturerId", false, "MANUFACTURER_ID");
        public final static Property VaccinateDoctorId = new Property(15, String.class, "vaccinateDoctorId", false, "VACCINATE_DOCTOR_ID");
        public final static Property VaccinateDoctorName = new Property(16, String.class, "vaccinateDoctorName", false, "VACCINATE_DOCTOR_NAME");
        public final static Property VaccinateOrgName = new Property(17, String.class, "vaccinateOrgName", false, "VACCINATE_ORG_NAME");
        public final static Property Remark = new Property(18, String.class, "remark", false, "REMARK");
        public final static Property IsCancel = new Property(19, Integer.class, "isCancel", false, "IS_CANCEL");
        public final static Property CreateOrgId = new Property(20, String.class, "createOrgId", false, "CREATE_ORG_ID");
        public final static Property OrgName = new Property(21, String.class, "orgName", false, "ORG_NAME");
        public final static Property CreatorId = new Property(22, String.class, "creatorId", false, "CREATOR_ID");
        public final static Property Creator = new Property(23, String.class, "creator", false, "CREATOR");
        public final static Property CreateTime = new Property(24, java.util.Date.class, "createTime", false, "CREATE_TIME");
        public final static Property ModifiedOrgId = new Property(25, String.class, "modifiedOrgId", false, "MODIFIED_ORG_ID");
        public final static Property ModifiedOrgName = new Property(26, String.class, "modifiedOrgName", false, "MODIFIED_ORG_NAME");
        public final static Property ModifierId = new Property(27, String.class, "modifierId", false, "MODIFIER_ID");
        public final static Property Modifier = new Property(28, String.class, "modifier", false, "MODIFIER");
        public final static Property ModifiedTime = new Property(29, java.util.Date.class, "modifiedTime", false, "MODIFIED_TIME");
    };


    public CdcVaccreportVaccinateDao(DaoConfig config) {
        super(config);
    }
    
    public CdcVaccreportVaccinateDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CDC_VACCREPORT_VACCINATE\" (" + //
                "\"CDC_VACCREPORT_VACCINATE_ID\" TEXT," + // 0: cdcVaccreportVaccinateId
                "\"PERSON_INFO_ID\" TEXT," + // 1: personInfoId
                "\"CDC_VACCREPORT_ID\" TEXT," + // 2: cdcVaccreportId
                "\"CDC_VACCREPORT_VACCINATE_NO\" TEXT," + // 3: cdcVaccreportVaccinateNo
                "\"VACCINE_ID\" TEXT," + // 4: vaccineId
                "\"VACCINE_NAME\" TEXT," + // 5: vaccineName
                "\"VACCINATE_PLAN_DATE\" INTEGER," + // 6: vaccinatePlanDate
                "\"VACCINATE_DATE\" INTEGER," + // 7: vaccinateDate
                "\"VACCINATE_SITE_CODE\" TEXT," + // 8: vaccinateSiteCode
                "\"VACCINATE_SITE_VALUE\" TEXT," + // 9: vaccinateSiteValue
                "\"VACCINE_BATCH_NO\" TEXT," + // 10: vaccineBatchNo
                "\"INJECT_TIMES_ID\" TEXT," + // 11: injectTimesId
                "\"VACCINATE_DOSES\" INTEGER," + // 12: vaccinateDoses
                "\"MEASURE\" TEXT," + // 13: measure
                "\"MANUFACTURER_ID\" TEXT," + // 14: manufacturerId
                "\"VACCINATE_DOCTOR_ID\" TEXT," + // 15: vaccinateDoctorId
                "\"VACCINATE_DOCTOR_NAME\" TEXT," + // 16: vaccinateDoctorName
                "\"VACCINATE_ORG_NAME\" TEXT," + // 17: vaccinateOrgName
                "\"REMARK\" TEXT," + // 18: remark
                "\"IS_CANCEL\" INTEGER," + // 19: isCancel
                "\"CREATE_ORG_ID\" TEXT," + // 20: createOrgId
                "\"ORG_NAME\" TEXT," + // 21: orgName
                "\"CREATOR_ID\" TEXT," + // 22: creatorId
                "\"CREATOR\" TEXT," + // 23: creator
                "\"CREATE_TIME\" INTEGER," + // 24: createTime
                "\"MODIFIED_ORG_ID\" TEXT," + // 25: modifiedOrgId
                "\"MODIFIED_ORG_NAME\" TEXT," + // 26: modifiedOrgName
                "\"MODIFIER_ID\" TEXT," + // 27: modifierId
                "\"MODIFIER\" TEXT," + // 28: modifier
                "\"MODIFIED_TIME\" INTEGER);"); // 29: modifiedTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CDC_VACCREPORT_VACCINATE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CdcVaccreportVaccinate entity) {
        stmt.clearBindings();
 
        String cdcVaccreportVaccinateId = entity.getCdcVaccreportVaccinateId();
        if (cdcVaccreportVaccinateId != null) {
            stmt.bindString(1, cdcVaccreportVaccinateId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(2, personInfoId);
        }
 
        String cdcVaccreportId = entity.getCdcVaccreportId();
        if (cdcVaccreportId != null) {
            stmt.bindString(3, cdcVaccreportId);
        }
 
        String cdcVaccreportVaccinateNo = entity.getCdcVaccreportVaccinateNo();
        if (cdcVaccreportVaccinateNo != null) {
            stmt.bindString(4, cdcVaccreportVaccinateNo);
        }
 
        String vaccineId = entity.getVaccineId();
        if (vaccineId != null) {
            stmt.bindString(5, vaccineId);
        }
 
        String vaccineName = entity.getVaccineName();
        if (vaccineName != null) {
            stmt.bindString(6, vaccineName);
        }
 
        java.util.Date vaccinatePlanDate = entity.getVaccinatePlanDate();
        if (vaccinatePlanDate != null) {
            stmt.bindLong(7, vaccinatePlanDate.getTime());
        }
 
        java.util.Date vaccinateDate = entity.getVaccinateDate();
        if (vaccinateDate != null) {
            stmt.bindLong(8, vaccinateDate.getTime());
        }
 
        String vaccinateSiteCode = entity.getVaccinateSiteCode();
        if (vaccinateSiteCode != null) {
            stmt.bindString(9, vaccinateSiteCode);
        }
 
        String vaccinateSiteValue = entity.getVaccinateSiteValue();
        if (vaccinateSiteValue != null) {
            stmt.bindString(10, vaccinateSiteValue);
        }
 
        String vaccineBatchNo = entity.getVaccineBatchNo();
        if (vaccineBatchNo != null) {
            stmt.bindString(11, vaccineBatchNo);
        }
 
        String injectTimesId = entity.getInjectTimesId();
        if (injectTimesId != null) {
            stmt.bindString(12, injectTimesId);
        }
 
        Integer vaccinateDoses = entity.getVaccinateDoses();
        if (vaccinateDoses != null) {
            stmt.bindLong(13, vaccinateDoses);
        }
 
        String measure = entity.getMeasure();
        if (measure != null) {
            stmt.bindString(14, measure);
        }
 
        String manufacturerId = entity.getManufacturerId();
        if (manufacturerId != null) {
            stmt.bindString(15, manufacturerId);
        }
 
        String vaccinateDoctorId = entity.getVaccinateDoctorId();
        if (vaccinateDoctorId != null) {
            stmt.bindString(16, vaccinateDoctorId);
        }
 
        String vaccinateDoctorName = entity.getVaccinateDoctorName();
        if (vaccinateDoctorName != null) {
            stmt.bindString(17, vaccinateDoctorName);
        }
 
        String vaccinateOrgName = entity.getVaccinateOrgName();
        if (vaccinateOrgName != null) {
            stmt.bindString(18, vaccinateOrgName);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(19, remark);
        }
 
        Integer isCancel = entity.getIsCancel();
        if (isCancel != null) {
            stmt.bindLong(20, isCancel);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(21, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(22, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(23, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(24, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(25, createTime.getTime());
        }
 
        String modifiedOrgId = entity.getModifiedOrgId();
        if (modifiedOrgId != null) {
            stmt.bindString(26, modifiedOrgId);
        }
 
        String modifiedOrgName = entity.getModifiedOrgName();
        if (modifiedOrgName != null) {
            stmt.bindString(27, modifiedOrgName);
        }
 
        String modifierId = entity.getModifierId();
        if (modifierId != null) {
            stmt.bindString(28, modifierId);
        }
 
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(29, modifier);
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(30, modifiedTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CdcVaccreportVaccinate entity) {
        stmt.clearBindings();
 
        String cdcVaccreportVaccinateId = entity.getCdcVaccreportVaccinateId();
        if (cdcVaccreportVaccinateId != null) {
            stmt.bindString(1, cdcVaccreportVaccinateId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(2, personInfoId);
        }
 
        String cdcVaccreportId = entity.getCdcVaccreportId();
        if (cdcVaccreportId != null) {
            stmt.bindString(3, cdcVaccreportId);
        }
 
        String cdcVaccreportVaccinateNo = entity.getCdcVaccreportVaccinateNo();
        if (cdcVaccreportVaccinateNo != null) {
            stmt.bindString(4, cdcVaccreportVaccinateNo);
        }
 
        String vaccineId = entity.getVaccineId();
        if (vaccineId != null) {
            stmt.bindString(5, vaccineId);
        }
 
        String vaccineName = entity.getVaccineName();
        if (vaccineName != null) {
            stmt.bindString(6, vaccineName);
        }
 
        java.util.Date vaccinatePlanDate = entity.getVaccinatePlanDate();
        if (vaccinatePlanDate != null) {
            stmt.bindLong(7, vaccinatePlanDate.getTime());
        }
 
        java.util.Date vaccinateDate = entity.getVaccinateDate();
        if (vaccinateDate != null) {
            stmt.bindLong(8, vaccinateDate.getTime());
        }
 
        String vaccinateSiteCode = entity.getVaccinateSiteCode();
        if (vaccinateSiteCode != null) {
            stmt.bindString(9, vaccinateSiteCode);
        }
 
        String vaccinateSiteValue = entity.getVaccinateSiteValue();
        if (vaccinateSiteValue != null) {
            stmt.bindString(10, vaccinateSiteValue);
        }
 
        String vaccineBatchNo = entity.getVaccineBatchNo();
        if (vaccineBatchNo != null) {
            stmt.bindString(11, vaccineBatchNo);
        }
 
        String injectTimesId = entity.getInjectTimesId();
        if (injectTimesId != null) {
            stmt.bindString(12, injectTimesId);
        }
 
        Integer vaccinateDoses = entity.getVaccinateDoses();
        if (vaccinateDoses != null) {
            stmt.bindLong(13, vaccinateDoses);
        }
 
        String measure = entity.getMeasure();
        if (measure != null) {
            stmt.bindString(14, measure);
        }
 
        String manufacturerId = entity.getManufacturerId();
        if (manufacturerId != null) {
            stmt.bindString(15, manufacturerId);
        }
 
        String vaccinateDoctorId = entity.getVaccinateDoctorId();
        if (vaccinateDoctorId != null) {
            stmt.bindString(16, vaccinateDoctorId);
        }
 
        String vaccinateDoctorName = entity.getVaccinateDoctorName();
        if (vaccinateDoctorName != null) {
            stmt.bindString(17, vaccinateDoctorName);
        }
 
        String vaccinateOrgName = entity.getVaccinateOrgName();
        if (vaccinateOrgName != null) {
            stmt.bindString(18, vaccinateOrgName);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(19, remark);
        }
 
        Integer isCancel = entity.getIsCancel();
        if (isCancel != null) {
            stmt.bindLong(20, isCancel);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(21, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(22, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(23, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(24, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(25, createTime.getTime());
        }
 
        String modifiedOrgId = entity.getModifiedOrgId();
        if (modifiedOrgId != null) {
            stmt.bindString(26, modifiedOrgId);
        }
 
        String modifiedOrgName = entity.getModifiedOrgName();
        if (modifiedOrgName != null) {
            stmt.bindString(27, modifiedOrgName);
        }
 
        String modifierId = entity.getModifierId();
        if (modifierId != null) {
            stmt.bindString(28, modifierId);
        }
 
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(29, modifier);
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(30, modifiedTime.getTime());
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public CdcVaccreportVaccinate readEntity(Cursor cursor, int offset) {
        CdcVaccreportVaccinate entity = new CdcVaccreportVaccinate( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // cdcVaccreportVaccinateId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // personInfoId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // cdcVaccreportId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // cdcVaccreportVaccinateNo
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // vaccineId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // vaccineName
            cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)), // vaccinatePlanDate
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)), // vaccinateDate
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // vaccinateSiteCode
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // vaccinateSiteValue
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // vaccineBatchNo
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // injectTimesId
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // vaccinateDoses
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // measure
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // manufacturerId
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // vaccinateDoctorId
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // vaccinateDoctorName
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // vaccinateOrgName
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // remark
            cursor.isNull(offset + 19) ? null : cursor.getInt(offset + 19), // isCancel
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // createOrgId
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // orgName
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // creatorId
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // creator
            cursor.isNull(offset + 24) ? null : new java.util.Date(cursor.getLong(offset + 24)), // createTime
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // modifiedOrgId
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // modifiedOrgName
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // modifierId
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // modifier
            cursor.isNull(offset + 29) ? null : new java.util.Date(cursor.getLong(offset + 29)) // modifiedTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CdcVaccreportVaccinate entity, int offset) {
        entity.setCdcVaccreportVaccinateId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPersonInfoId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCdcVaccreportId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCdcVaccreportVaccinateNo(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setVaccineId(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setVaccineName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setVaccinatePlanDate(cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)));
        entity.setVaccinateDate(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
        entity.setVaccinateSiteCode(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setVaccinateSiteValue(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setVaccineBatchNo(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setInjectTimesId(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setVaccinateDoses(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setMeasure(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setManufacturerId(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setVaccinateDoctorId(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setVaccinateDoctorName(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setVaccinateOrgName(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setRemark(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setIsCancel(cursor.isNull(offset + 19) ? null : cursor.getInt(offset + 19));
        entity.setCreateOrgId(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setOrgName(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setCreatorId(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setCreator(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setCreateTime(cursor.isNull(offset + 24) ? null : new java.util.Date(cursor.getLong(offset + 24)));
        entity.setModifiedOrgId(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setModifiedOrgName(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setModifierId(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setModifier(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setModifiedTime(cursor.isNull(offset + 29) ? null : new java.util.Date(cursor.getLong(offset + 29)));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(CdcVaccreportVaccinate entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(CdcVaccreportVaccinate entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
