package pineapple.iq_quest.database;

import android.provider.BaseColumns;


// DataBase Table
public final class DataBases {
	
	public static final class CreateDB implements BaseColumns {
		public static final String NAME = "name";
		public static final String OLD = "old";
		public static final String EMAIL = "email";
		public static final String _TABLENAME = "address";
		public static final String _CREATE = 
			"create table "+_TABLENAME+"(" 
					+_ID+" integer primary key autoincrement, " 	
					+NAME+" text not null , " 
					+OLD+" text not null , "
					+EMAIL+" text not null );";
	}
}
