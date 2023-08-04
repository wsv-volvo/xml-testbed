package com.volvocars.xmltestbed.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element

data class TestDetailDto
@JvmOverloads constructor(
    @field:Attribute var id: String = "",
    @field:Element var bool: Boolean? = null,
    @field:Element var intNumber: Int? = null,
    @field:Element var floatNumber: Float? = null,
    @field:Element var enumValue: TestEnum? = null
)
