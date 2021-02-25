/*
 * QNotified - An Xposed module for QQ/TIM
 * Copyright (C) 2019-2021 dmca@ioctl.cc
 * https://github.com/ferredoxin/QNotified
 *
 * This software is non-free but opensource software: you can redistribute it
 * and/or modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either
 * version 3 of the License, or any later version and our eula as published
 * by ferredoxin.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * and eula along with this software.  If not, see
 * <https://www.gnu.org/licenses/>
 * <https://github.com/ferredoxin/QNotified/blob/master/LICENSE.md>.
 */

package me.singleneuron.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MiniAppArkData {

    lateinit var desc: String
    lateinit var prompt: String
    lateinit var meta: Map<String,MiniAppArkDetailData>
    lateinit var config: ArkMsgConfigData
    lateinit var extra: String

    companion object {
        @JvmStatic
        fun fromJson(json: String): MiniAppArkData {
            val type: Type = object : TypeToken<MiniAppArkData>(){}.type
            return Gson().fromJson(json, type)
        }
    }

    override fun toString(): String {
        return Gson().toJson(this)
    }
}

class MiniAppArkDetailData {
    lateinit var desc: String
    lateinit var preview: String
    lateinit var qqdocurl: String
    lateinit var title: String
}

class ArkMsgConfigData {
    var ctime: Long = System.currentTimeMillis()/1000
}
