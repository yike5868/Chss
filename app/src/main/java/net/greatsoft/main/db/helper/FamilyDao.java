package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.family.Family;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FAMILY".
*/
public class FamilyDao extends AbstractDao<Family, Void> {

    public static final String TABLENAME = "FAMILY";

    /**
     * Properties of entity Family.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property FamilyId = new Property(0, String.class, "familyId", false, "FAMILY_ID");
        public final static Property DistrictId = new Property(1, String.class, "districtId", false, "DISTRICT_ID");
        public final static Property Householder = new Property(2, String.class, "householder", false, "HOUSEHOLDER");
        public final static Property HouseholderIdNo = new Property(3, String.class, "householderIdNo", false, "HOUSEHOLDER_ID_NO");
        public final static Property Address = new Property(4, String.class, "address", false, "ADDRESS");
        public final static Property TelNo = new Property(5, String.class, "telNo", false, "TEL_NO");
        public final static Property FamilyStatusCode = new Property(6, String.class, "familyStatusCode", false, "FAMILY_STATUS_CODE");
        public final static Property CancelReasonCode = new Property(7, String.class, "cancelReasonCode", false, "CANCEL_REASON_CODE");
        public final static Property CancelTime = new Property(8, java.util.Date.class, "cancelTime", false, "CANCEL_TIME");
        public final static Property CreateTime = new Property(9, java.util.Date.class, "createTime", false, "CREATE_TIME");
        public final static Property ModifiedTime = new Property(10, java.util.Date.class, "modifiedTime", false, "MODIFIED_TIME");
    };


    public FamilyDao(DaoConfig config) {
        super(config);
    }
    
    public FamilyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FAMILY\" (" + //
                "\"FAMILY_ID\" TEXT," + // 0: familyId
                "\"DISTRICT_ID\" TEXT," + // 1: districtId
                "\"HOUSEHOLDER\" TEXT," + // 2: householder
                "\"HOUSEHOLDER_ID_NO\" TEXT," + // 3: householderIdNo
                "\"ADDRESS\" TEXT," + // 4: address
                "\"TEL_NO\" TEXT," + // 5: telNo
                "\"FAMILY_STATUS_CODE\" TEXT," + // 6: familyStatusCode
                "\"CANCEL_REASON_CODE\" TEXT," + // 7: cancelReasonCode
                "\"CANCEL_TIME\" INTEGER," + // 8: cancelTime
                "\"CREATE_TIME\" INTEGER," + // 9: createTime
                "\"MODIFIED_TIME\" INTEGER);"); // 10: modifiedTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FAMILY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Family entity) {
        stmt.clearBindings();
 
        String familyId = entity.getFamilyId();
        if (familyId != null) {
            stmt.bindString(1, familyId);
        }
 
        String districtId = entity.getDistrictId();
        if (districtId != null) {
            stmt.bindString(2, districtId);
        }
 
        String householder = entity.getHouseholder();
        if (householder != null) {
            stmt.bindString(3, householder);
        }
 
        String householderIdNo = entity.getHouseholderIdNo();
        if (householderIdNo != null) {
            stmt.bindString(4, householderIdNo);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
 
        String telNo = entity.getTelNo();
        if (telNo != null) {
            stmt.bindString(6, telNo);
        }
 
        String familyStatusCode = entity.getFamilyStatusCode();
        if (familyStatusCode != null) {
            stmt.bindString(7, familyStatusCode);
        }
 
        String cancelReasonCode = entity.getCancelReasonCode();
        if (cancelReasonCode != null) {
            stmt.bindString(8, cancelReasonCode);
        }
 
        java.util.Date cancelTime = entity.getCancelTime();
        if (cancelTime != null) {
            stmt.bindLong(9, cancelTime.getTime());
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(10, createTime.getTime());
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(11, modifiedTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Family entity) {
        stmt.clearBindings();
 
        String familyId = entity.getFamilyId();
        if (familyId != null) {
            stmt.bindString(1, familyId);
        }
 
        String districtId = entity.getDistrictId();
        if (districtId != null) {
            stmt.bindString(2, districtId);
        }
 
        String householder = entity.getHouseholder();
        if (householder != null) {
            stmt.bindString(3, householder);
        }
 
        String householderIdNo = entity.getHouseholderIdNo();
        if (householderIdNo != null) {
            stmt.bindString(4, householderIdNo);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
 
        String telNo = entity.getTelNo();
        if (telNo != null) {
            stmt.bindString(6, telNo);
        }
 
        String familyStatusCode = entity.getFamilyStatusCode();
        if (familyStatusCode != null) {
            stmt.bindString(7, familyStatusCode);
        }
 
        String cancelReasonCode = entity.getCancelReasonCode();
        if (cancelReasonCode != null) {
            stmt.bindString(8, cancelReasonCode);
        }
 
        java.util.Date cancelTime = entity.getCancelTime();
        if (cancelTime != null) {
            stmt.bindLong(9, cancelTime.getTime());
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(10, createTime.getTime());
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(11, modifiedTime.getTime());
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Family readEntity(Cursor cursor, int offset) {
        Family entity = new Family( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // familyId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // districtId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // householder
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // householderIdNo
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // address
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // telNo
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // familyStatusCode
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // cancelReasonCode
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)), // cancelTime
            cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)), // createTime
            cursor.isNull(offset + 10) ? null : new java.util.Date(cursor.getLong(offset + 10)) // modifiedTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Family entity, int offset) {
        entity.setFamilyId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDistrictId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setHouseholder(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setHouseholderIdNo(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAddress(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTelNo(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFamilyStatusCode(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCancelReasonCode(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCancelTime(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
        entity.setCreateTime(cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)));
        entity.setModifiedTime(cursor.isNull(offset + 10) ? null : new java.util.Date(cursor.getLong(offset + 10)));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Family entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Family entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
