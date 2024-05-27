package com.example.a002loginexample.dataBase

import io.realm.kotlin.RealmConfiguration

open class BaseDAO {

    private val allStores by lazy{
        realmCardsDAO.STORES
    }

    companion object {
        private const val DATABASE_SCHEMA_VERSION = 1L
    }

    val config by lazy {
        RealmConfiguration
            .Builder(allStores)
            .name("tc.realm")
            .schemaVersion(DATABASE_SCHEMA_VERSION)
            .deleteRealmIfMigrationNeeded()
            .build()
    }
}