package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.exam.HealthExamDrug;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HEALTH_EXAM_DRUG".
*/
public class HealthExamDrugDao extends AbstractDao<HealthExamDrug, Void> {

    public static final String TABLENAME = "HEALTH_EXAM_DRUG";

    /**
     * Properties of entity HealthExamDrug.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property HealthExamId = new Property(0, String.class, "healthExamId", false, "HEALTH_EXAM_ID");
        public final static Property DrugName = new Property(1, String.class, "drugName", false, "DRUG_NAME");
        public final static Property DrugUsageCode = new Property(2, String.class, "drugUsageCode", false, "DRUG_USAGE_CODE");
        public final static Property DrugDose = new Property(3, String.class, "drugDose", false, "DRUG_DOSE");
        public final static Property DrugTime = new Property(4, String.class, "drugTime", false, "DRUG_TIME");
        public final static Property DrugComplianceCode = new Property(5, String.class, "drugComplianceCode", false, "DRUG_COMPLIANCE_CODE");
        public final static Property DrugComplianceValue = new Property(6, String.class, "drugComplianceValue", false, "DRUG_COMPLIANCE_VALUE");
    };


    public HealthExamDrugDao(DaoConfig config) {
        super(config);
    }
    
    public HealthExamDrugDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HEALTH_EXAM_DRUG\" (" + //
                "\"HEALTH_EXAM_ID\" TEXT," + // 0: healthExamId
                "\"DRUG_NAME\" TEXT," + // 1: drugName
                "\"DRUG_USAGE_CODE\" TEXT," + // 2: drugUsageCode
                "\"DRUG_DOSE\" TEXT," + // 3: drugDose
                "\"DRUG_TIME\" TEXT," + // 4: drugTime
                "\"DRUG_COMPLIANCE_CODE\" TEXT," + // 5: drugComplianceCode
                "\"DRUG_COMPLIANCE_VALUE\" TEXT);"); // 6: drugComplianceValue
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HEALTH_EXAM_DRUG\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, HealthExamDrug entity) {
        stmt.clearBindings();
 
        String healthExamId = entity.getHealthExamId();
        if (healthExamId != null) {
            stmt.bindString(1, healthExamId);
        }
 
        String drugName = entity.getDrugName();
        if (drugName != null) {
            stmt.bindString(2, drugName);
        }
 
        String drugUsageCode = entity.getDrugUsageCode();
        if (drugUsageCode != null) {
            stmt.bindString(3, drugUsageCode);
        }
 
        String drugDose = entity.getDrugDose();
        if (drugDose != null) {
            stmt.bindString(4, drugDose);
        }
 
        String drugTime = entity.getDrugTime();
        if (drugTime != null) {
            stmt.bindString(5, drugTime);
        }
 
        String drugComplianceCode = entity.getDrugComplianceCode();
        if (drugComplianceCode != null) {
            stmt.bindString(6, drugComplianceCode);
        }
 
        String drugComplianceValue = entity.getDrugComplianceValue();
        if (drugComplianceValue != null) {
            stmt.bindString(7, drugComplianceValue);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, HealthExamDrug entity) {
        stmt.clearBindings();
 
        String healthExamId = entity.getHealthExamId();
        if (healthExamId != null) {
            stmt.bindString(1, healthExamId);
        }
 
        String drugName = entity.getDrugName();
        if (drugName != null) {
            stmt.bindString(2, drugName);
        }
 
        String drugUsageCode = entity.getDrugUsageCode();
        if (drugUsageCode != null) {
            stmt.bindString(3, drugUsageCode);
        }
 
        String drugDose = entity.getDrugDose();
        if (drugDose != null) {
            stmt.bindString(4, drugDose);
        }
 
        String drugTime = entity.getDrugTime();
        if (drugTime != null) {
            stmt.bindString(5, drugTime);
        }
 
        String drugComplianceCode = entity.getDrugComplianceCode();
        if (drugComplianceCode != null) {
            stmt.bindString(6, drugComplianceCode);
        }
 
        String drugComplianceValue = entity.getDrugComplianceValue();
        if (drugComplianceValue != null) {
            stmt.bindString(7, drugComplianceValue);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public HealthExamDrug readEntity(Cursor cursor, int offset) {
        HealthExamDrug entity = new HealthExamDrug( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // healthExamId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // drugName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // drugUsageCode
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // drugDose
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // drugTime
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // drugComplianceCode
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // drugComplianceValue
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, HealthExamDrug entity, int offset) {
        entity.setHealthExamId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDrugName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDrugUsageCode(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDrugDose(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDrugTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDrugComplianceCode(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDrugComplianceValue(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(HealthExamDrug entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(HealthExamDrug entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
