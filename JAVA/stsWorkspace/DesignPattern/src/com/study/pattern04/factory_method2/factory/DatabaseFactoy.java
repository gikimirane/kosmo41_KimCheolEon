package com.study.pattern04.factory_method2.factory;

import com.study.pattern04.factory_method2.database.Database;

enum DBType {
	MySQL, Orcle, InforMix
}

//<summary>
//The 'Creator' abstract class
//</summary>

public abstract class DatabaseFactoy {

	// Factory method
	public abstract Database setDatabase();
}
