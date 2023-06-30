package xyz.yingshaoxo.calling2email.logs.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import xyz.yingshaoxo.calling2email.logs.data.AppPackage

@Dao
interface AppPackageDao {
    
    @Query("SELECT [index] FROM app_packages WHERE package_name=:packageName")
    fun getPackageIndex(packageName: String?): Int

    @Insert
    fun insertAppPackage(appPackage: AppPackage?)
}