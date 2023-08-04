package com.volvocars.xmltestbed.model

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/*
 * Object with attribute and elements
 * Basic elements of various types
 * Elements with custom names
 */
@Xml
data class TestDetailDto(
    @Attribute val id: String = "",
    @PropertyElement val bool: Boolean? = null,
    @PropertyElement(name = "int") val intNumber: Int? = null,
    @PropertyElement(name = "float") val floatNumber: Double? = null, // has to be Double, tikxml does not support Float!
    @PropertyElement(name = "enum") val enumValue: TestEnum? = null
)
