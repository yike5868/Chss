package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.rsp.SessionRsp;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SESSION_RSP".
*/
public class SessionRspDao extends AbstractDao<SessionRsp, Void> {

    public static final String TABLENAME = "SESSION_RSP";

    /**
     * Properties of entity SessionRsp.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Pos_id = new Property(0, String.class, "pos_id", false, "POS_ID");
        public final static Property Pos_name = new Property(1, String.class, "pos_name", false, "POS_NAME");
        public final static Property Pos_code = new Property(2, String.class, "pos_code", false, "POS_CODE");
        public final static Property Dept_id = new Property(3, String.class, "dept_id", false, "DEPT_ID");
        public final static Property Dept_name = new Property(4, String.class, "dept_name", false, "DEPT_NAME");
        public final static Property Emp_id = new Property(5, String.class, "emp_id", false, "EMP_ID");
        public final static Property Emp_name = new Property(6, String.class, "emp_name", false, "EMP_NAME");
        public final static Property District_id = new Property(7, String.class, "district_id", false, "DISTRICT_ID");
        public final static Property District_name = new Property(8, String.class, "district_name", false, "DISTRICT_NAME");
        public final static Property District_level = new Property(9, String.class, "district_level", false, "DISTRICT_LEVEL");
        public final static Property Is_gw = new Property(10, String.class, "is_gw", false, "IS_GW");
        public final static Property Emp_rin = new Property(11, String.class, "emp_rin", false, "EMP_RIN");
        public final static Property Emp_gender = new Property(12, String.class, "emp_gender", false, "EMP_GENDER");
        public final static Property Emp_mobile = new Property(13, String.class, "emp_mobile", false, "EMP_MOBILE");
        public final static Property Emp_title = new Property(14, String.class, "emp_title", false, "EMP_TITLE");
        public final static Property Emp_birthday = new Property(15, String.class, "emp_birthday", false, "EMP_BIRTHDAY");
        public final static Property Emp_property = new Property(16, String.class, "emp_property", false, "EMP_PROPERTY");
        public final static Property Pos_pid = new Property(17, String.class, "pos_pid", false, "POS_PID");
    };


    public SessionRspDao(DaoConfig config) {
        super(config);
    }
    
    public SessionRspDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SESSION_RSP\" (" + //
                "\"POS_ID\" TEXT," + // 0: pos_id
                "\"POS_NAME\" TEXT," + // 1: pos_name
                "\"POS_CODE\" TEXT," + // 2: pos_code
                "\"DEPT_ID\" TEXT," + // 3: dept_id
                "\"DEPT_NAME\" TEXT," + // 4: dept_name
                "\"EMP_ID\" TEXT," + // 5: emp_id
                "\"EMP_NAME\" TEXT," + // 6: emp_name
                "\"DISTRICT_ID\" TEXT," + // 7: district_id
                "\"DISTRICT_NAME\" TEXT," + // 8: district_name
                "\"DISTRICT_LEVEL\" TEXT," + // 9: district_level
                "\"IS_GW\" TEXT," + // 10: is_gw
                "\"EMP_RIN\" TEXT," + // 11: emp_rin
                "\"EMP_GENDER\" TEXT," + // 12: emp_gender
                "\"EMP_MOBILE\" TEXT," + // 13: emp_mobile
                "\"EMP_TITLE\" TEXT," + // 14: emp_title
                "\"EMP_BIRTHDAY\" TEXT," + // 15: emp_birthday
                "\"EMP_PROPERTY\" TEXT," + // 16: emp_property
                "\"POS_PID\" TEXT);"); // 17: pos_pid
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SESSION_RSP\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SessionRsp entity) {
        stmt.clearBindings();
 
        String pos_id = entity.getPos_id();
        if (pos_id != null) {
            stmt.bindString(1, pos_id);
        }
 
        String pos_name = entity.getPos_name();
        if (pos_name != null) {
            stmt.bindString(2, pos_name);
        }
 
        String pos_code = entity.getPos_code();
        if (pos_code != null) {
            stmt.bindString(3, pos_code);
        }
 
        String dept_id = entity.getDept_id();
        if (dept_id != null) {
            stmt.bindString(4, dept_id);
        }
 
        String dept_name = entity.getDept_name();
        if (dept_name != null) {
            stmt.bindString(5, dept_name);
        }
 
        String emp_id = entity.getEmp_id();
        if (emp_id != null) {
            stmt.bindString(6, emp_id);
        }
 
        String emp_name = entity.getEmp_name();
        if (emp_name != null) {
            stmt.bindString(7, emp_name);
        }
 
        String district_id = entity.getDistrict_id();
        if (district_id != null) {
            stmt.bindString(8, district_id);
        }
 
        String district_name = entity.getDistrict_name();
        if (district_name != null) {
            stmt.bindString(9, district_name);
        }
 
        String district_level = entity.getDistrict_level();
        if (district_level != null) {
            stmt.bindString(10, district_level);
        }
 
        String is_gw = entity.getIs_gw();
        if (is_gw != null) {
            stmt.bindString(11, is_gw);
        }
 
        String emp_rin = entity.getEmp_rin();
        if (emp_rin != null) {
            stmt.bindString(12, emp_rin);
        }
 
        String emp_gender = entity.getEmp_gender();
        if (emp_gender != null) {
            stmt.bindString(13, emp_gender);
        }
 
        String emp_mobile = entity.getEmp_mobile();
        if (emp_mobile != null) {
            stmt.bindString(14, emp_mobile);
        }
 
        String emp_title = entity.getEmp_title();
        if (emp_title != null) {
            stmt.bindString(15, emp_title);
        }
 
        String emp_birthday = entity.getEmp_birthday();
        if (emp_birthday != null) {
            stmt.bindString(16, emp_birthday);
        }
 
        String emp_property = entity.getEmp_property();
        if (emp_property != null) {
            stmt.bindString(17, emp_property);
        }
 
        String pos_pid = entity.getPos_pid();
        if (pos_pid != null) {
            stmt.bindString(18, pos_pid);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SessionRsp entity) {
        stmt.clearBindings();
 
        String pos_id = entity.getPos_id();
        if (pos_id != null) {
            stmt.bindString(1, pos_id);
        }
 
        String pos_name = entity.getPos_name();
        if (pos_name != null) {
            stmt.bindString(2, pos_name);
        }
 
        String pos_code = entity.getPos_code();
        if (pos_code != null) {
            stmt.bindString(3, pos_code);
        }
 
        String dept_id = entity.getDept_id();
        if (dept_id != null) {
            stmt.bindString(4, dept_id);
        }
 
        String dept_name = entity.getDept_name();
        if (dept_name != null) {
            stmt.bindString(5, dept_name);
        }
 
        String emp_id = entity.getEmp_id();
        if (emp_id != null) {
            stmt.bindString(6, emp_id);
        }
 
        String emp_name = entity.getEmp_name();
        if (emp_name != null) {
            stmt.bindString(7, emp_name);
        }
 
        String district_id = entity.getDistrict_id();
        if (district_id != null) {
            stmt.bindString(8, district_id);
        }
 
        String district_name = entity.getDistrict_name();
        if (district_name != null) {
            stmt.bindString(9, district_name);
        }
 
        String district_level = entity.getDistrict_level();
        if (district_level != null) {
            stmt.bindString(10, district_level);
        }
 
        String is_gw = entity.getIs_gw();
        if (is_gw != null) {
            stmt.bindString(11, is_gw);
        }
 
        String emp_rin = entity.getEmp_rin();
        if (emp_rin != null) {
            stmt.bindString(12, emp_rin);
        }
 
        String emp_gender = entity.getEmp_gender();
        if (emp_gender != null) {
            stmt.bindString(13, emp_gender);
        }
 
        String emp_mobile = entity.getEmp_mobile();
        if (emp_mobile != null) {
            stmt.bindString(14, emp_mobile);
        }
 
        String emp_title = entity.getEmp_title();
        if (emp_title != null) {
            stmt.bindString(15, emp_title);
        }
 
        String emp_birthday = entity.getEmp_birthday();
        if (emp_birthday != null) {
            stmt.bindString(16, emp_birthday);
        }
 
        String emp_property = entity.getEmp_property();
        if (emp_property != null) {
            stmt.bindString(17, emp_property);
        }
 
        String pos_pid = entity.getPos_pid();
        if (pos_pid != null) {
            stmt.bindString(18, pos_pid);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public SessionRsp readEntity(Cursor cursor, int offset) {
        SessionRsp entity = new SessionRsp( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // pos_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // pos_name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // pos_code
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // dept_id
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // dept_name
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // emp_id
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // emp_name
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // district_id
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // district_name
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // district_level
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // is_gw
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // emp_rin
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // emp_gender
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // emp_mobile
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // emp_title
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // emp_birthday
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // emp_property
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17) // pos_pid
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SessionRsp entity, int offset) {
        entity.setPos_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPos_name(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPos_code(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDept_id(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDept_name(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setEmp_id(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setEmp_name(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDistrict_id(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDistrict_name(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setDistrict_level(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setIs_gw(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setEmp_rin(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setEmp_gender(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setEmp_mobile(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setEmp_title(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setEmp_birthday(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setEmp_property(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setPos_pid(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(SessionRsp entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(SessionRsp entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
