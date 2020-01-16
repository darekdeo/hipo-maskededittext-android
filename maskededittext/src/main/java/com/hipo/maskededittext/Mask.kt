package com.hipo.maskededittext

abstract class Mask {
    abstract val maskPattern: String
    abstract val returnPattern: String

    abstract fun getParsedText(maskedText: String): String?
    abstract fun isValidToParse(maskedText: String): Boolean
    abstract fun filterMaskedText(maskedText: String): String

    enum class Type : MaskCreator {
        DATE {
            override fun create(maskPattern: String?, returnPattern: String?): Mask = DateMask()
        },
        PHONE {
            override fun create(maskPattern: String?, returnPattern: String?): Mask = PhoneMask()
        },
        SSN {
            override fun create(maskPattern: String?, returnPattern: String?): Mask = SSNMask()
        },
        CURRENCY {
            override fun create(maskPattern: String?, returnPattern: String?): Mask = CurrencyMask()
        },
        CUSTOM {
            override fun create(maskPattern: String?, returnPattern: String?): Mask =
                CustomMask(maskPattern.orEmpty(), returnPattern.orEmpty())
        },
        STATIC_TEXT {
            override fun create(maskPattern: String?, returnPattern: String?) = StaticTextMask(maskPattern!!)
        },
        UNSELECTED {
            override fun create(maskPattern: String?, returnPattern: String?): Mask = UnselectedMask()
        }
    }
}
