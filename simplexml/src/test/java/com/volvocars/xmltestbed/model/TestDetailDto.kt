package com.volvocars.xmltestbed.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element

/*
 * Object with attribute and elements
 * Basic elements of various types
 * Elements with custom names
 */
data class TestDetailDto
@JvmOverloads constructor(
    @field:Attribute var id: String = "",
    @field:Element(required = false) var bool: Boolean? = null,
    @field:Element(name = "int", required = false) var intNumber: Int? = null,
    @field:Element(name = "float", required = false) var floatNumber: Float? = null,
    @field:Element(name = "enum", required = false) var enumValue: TestEnum? = null
)
