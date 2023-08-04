package com.volvocars.xmltestbed.model

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

/*
 * Object with only attributes
 */
@Xml
data class TestItemDto(
    @Attribute val id: String = "",
    @Attribute val value: Int = 0
)
