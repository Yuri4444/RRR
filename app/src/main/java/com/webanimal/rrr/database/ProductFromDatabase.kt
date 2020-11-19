package com.webanimal.rrr.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductFromDatabase(
        @PrimaryKey(autoGenerate = true) val uid: Int?,

        @ColumnInfo val title: String,

        @ColumnInfo val price: Double
//        @ColumnInfo val isOnSale: Boolean
)