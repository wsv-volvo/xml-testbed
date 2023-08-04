package com.volvocars.xmltestbed

import com.tickaroo.tikxml.TypeConverter
import com.volvocars.xmltestbed.model.TestEnum

class TestEnumTypeConverter : TypeConverter<TestEnum> {
    override fun read(value: String?): TestEnum? {
        if (null == value) return null
        return enumValueOf<TestEnum>(value)
    }

    override fun write(value: TestEnum?): String? =
        value?.toString()
}
