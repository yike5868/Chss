package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.diabetes.DiabetesFollowupDrug;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DIABETES_FOLLOWUP_DRUG".
*/
public class DiabetesFollowupDrugDao extends AbstractDao<DiabetesFollowupDrug, Void> {

    public static final String TABLENAME = "DIABETES_FOLLOWUP_DRUG";

    /**
     * Properties of entity DiabetesFollowupDrug.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property DiabetesFollowupDrugId = new Property(0, String.class, "diabetesFollowupDrugId", false, "DIABETES_FOLLOWUP_DRUG_ID");
        public final static Property DiabetesFollowupId = new Property(1, String.class, "diabetesFollowupId", false, "DIABETES_FOLLOWUP_ID");
        public final static Property DrugId = new Property(2, String.class, "drugId", false, "DRUG_ID");
        public final static Property DrugName = new Property(3, String.class, "drugName", false, "DRUG_NAME");
        public final static Property DrugUsingFreq = new Property(4, String.class, "drugUsingFreq", false, "DRUG_USING_FREQ");
        public final static Property DrugDoseUnit = new Property(5, String.class, "drugDoseUnit", false, "DRUG_DOSE_UNIT");
        public final static Property DrugPerDose = new Property(6, String.class, "drugPerDose", false, "DRUG_PER_DOSE");
        public final static Property Unit = new Property(7, String.class, "unit", false, "UNIT");
        public final static Property DrugTotalDose = new Property(8, Double.class, "drugTotalDose", false, "DRUG_TOTAL_DOSE");
        public final static Property DrugRouteCode = new Property(9, String.class, "drugRouteCode", false, "DRUG_ROUTE_CODE");
    };


    public DiabetesFollowupDrugDao(DaoConfig config) {
        super(config);
    }
    
    public DiabetesFollowupDrugDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DIABETES_FOLLOWUP_DRUG\" (" + //
                "\"DIABETES_FOLLOWUP_DRUG_ID\" TEXT," + // 0: diabetesFollowupDrugId
                "\"DIABETES_FOLLOWUP_ID\" TEXT," + // 1: diabetesFollowupId
                "\"DRUG_ID\" TEXT," + // 2: drugId
                "\"DRUG_NAME\" TEXT," + // 3: drugName
                "\"DRUG_USING_FREQ\" TEXT," + // 4: drugUsingFreq
                "\"DRUG_DOSE_UNIT\" TEXT," + // 5: drugDoseUnit
                "\"DRUG_PER_DOSE\" TEXT," + // 6: drugPerDose
                "\"UNIT\" TEXT," + // 7: unit
                "\"DRUG_TOTAL_DOSE\" REAL," + // 8: drugTotalDose
                "\"DRUG_ROUTE_CODE\" TEXT);"); // 9: drugRouteCode
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DIABETES_FOLLOWUP_DRUG\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DiabetesFollowupDrug entity) {
        stmt.clearBindings();
 
        String diabetesFollowupDrugId = entity.getDiabetesFollowupDrugId();
        if (diabetesFollowupDrugId != null) {
            stmt.bindString(1, diabetesFollowupDrugId);
        }
 
        String diabetesFollowupId = entity.getDiabetesFollowupId();
        if (diabetesFollowupId != null) {
            stmt.bindString(2, diabetesFollowupId);
        }
 
        String drugId = entity.getDrugId();
        if (drugId != null) {
            stmt.bindString(3, drugId);
        }
 
        String drugName = entity.getDrugName();
        if (drugName != null) {
            stmt.bindString(4, drugName);
        }
 
        String drugUsingFreq = entity.getDrugUsingFreq();
        if (drugUsingFreq != null) {
            stmt.bindString(5, drugUsingFreq);
        }
 
        String drugDoseUnit = entity.getDrugDoseUnit();
        if (drugDoseUnit != null) {
            stmt.bindString(6, drugDoseUnit);
        }
 
        String drugPerDose = entity.getDrugPerDose();
        if (drugPerDose != null) {
            stmt.bindString(7, drugPerDose);
        }
 
        String unit = entity.getUnit();
        if (unit != null) {
            stmt.bindString(8, unit);
        }
 
        Double drugTotalDose = entity.getDrugTotalDose();
        if (drugTotalDose != null) {
            stmt.bindDouble(9, drugTotalDose);
        }
 
        String drugRouteCode = entity.getDrugRouteCode();
        if (drugRouteCode != null) {
            stmt.bindString(10, drugRouteCode);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DiabetesFollowupDrug entity) {
        stmt.clearBindings();
 
        String diabetesFollowupDrugId = entity.getDiabetesFollowupDrugId();
        if (diabetesFollowupDrugId != null) {
            stmt.bindString(1, diabetesFollowupDrugId);
        }
 
        String diabetesFollowupId = entity.getDiabetesFollowupId();
        if (diabetesFollowupId != null) {
            stmt.bindString(2, diabetesFollowupId);
        }
 
        String drugId = entity.getDrugId();
        if (drugId != null) {
            stmt.bindString(3, drugId);
        }
 
        String drugName = entity.getDrugName();
        if (drugName != null) {
            stmt.bindString(4, drugName);
        }
 
        String drugUsingFreq = entity.getDrugUsingFreq();
        if (drugUsingFreq != null) {
            stmt.bindString(5, drugUsingFreq);
        }
 
        String drugDoseUnit = entity.getDrugDoseUnit();
        if (drugDoseUnit != null) {
            stmt.bindString(6, drugDoseUnit);
        }
 
        String drugPerDose = entity.getDrugPerDose();
        if (drugPerDose != null) {
            stmt.bindString(7, drugPerDose);
        }
 
        String unit = entity.getUnit();
        if (unit != null) {
            stmt.bindString(8, unit);
        }
 
        Double drugTotalDose = entity.getDrugTotalDose();
        if (drugTotalDose != null) {
            stmt.bindDouble(9, drugTotalDose);
        }
 
        String drugRouteCode = entity.getDrugRouteCode();
        if (drugRouteCode != null) {
            stmt.bindString(10, drugRouteCode);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public DiabetesFollowupDrug readEntity(Cursor cursor, int offset) {
        DiabetesFollowupDrug entity = new DiabetesFollowupDrug( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // diabetesFollowupDrugId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // diabetesFollowupId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // drugId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // drugName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // drugUsingFreq
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // drugDoseUnit
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // drugPerDose
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // unit
            cursor.isNull(offset + 8) ? null : cursor.getDouble(offset + 8), // drugTotalDose
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // drugRouteCode
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DiabetesFollowupDrug entity, int offset) {
        entity.setDiabetesFollowupDrugId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDiabetesFollowupId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDrugId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDrugName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDrugUsingFreq(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDrugDoseUnit(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDrugPerDose(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setUnit(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDrugTotalDose(cursor.isNull(offset + 8) ? null : cursor.getDouble(offset + 8));
        entity.setDrugRouteCode(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(DiabetesFollowupDrug entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(DiabetesFollowupDrug entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
