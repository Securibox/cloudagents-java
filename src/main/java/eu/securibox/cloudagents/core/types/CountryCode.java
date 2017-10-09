package eu.securibox.cloudagents.core.types;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


// TODO: Auto-generated Javadoc
/**
 * The Enum AgentCountryCode.
 */
@JsonDeserialize(using = CountryCodeDeserializer.class)
@JsonSerialize(using = CountryCodeSerializer.class)
public enum CountryCode {
    Undefined(0),				//Undefined
    GLOBAL(1),					//Special value for defining global country code
    AE(2),						//U.A.E.
    AF(3),						//Afghanistan
    AL(4),						//Albania
    AM(5),						//Armenia
    AR(6),						//Argentina
    AT(7),						//Austria
    AU(8),						//Australia
    AZ(9),						//Azerbaijan
    BA(10),						//Bosnia and Herzegovina
    BD(11),						//Bangladesh
    BE(12),						//Belgium
    BG(13),						//Bulgaria
    BH(14),						//Bahrain
    BN(15),						//Brunei Darussalam
    BO(16),						//Bolivia
    BR(17),						//Brazil
    BW(18),						//Botswana
    BY(19),						//Belarus
    BZ(20),						//Belize
    CA(21),						//Canada
    CD(22),						//Congo [DRC]
    CH(23),						//Switzerland
    CI(24),						//Ivory Coast
    CL(25),						//Chile
    CM(26),						//Cameroon
    CN(27),						//China
    CO(28),						//Colombia
    CR(29),						//Costa Rica
    CS(30),						//Serbia and Montenegro (Former)
    CZ(31),						//Czech Republic
    DE(32),						//Germany
    DK(33),						//Denmark
    DO(34),						//Dominican Republic
    DZ(35),						//Algeria
    EC(36),						//Ecuador
    EE(37),						//Estonia
    EG(38),						//Egypt
    ER(39),						//Eritrea
    ES(40),						//Spain
    ET(41),						//Ethiopia
    FI(42),						//Finland
    FO(43),						//Faroe Islands
    FR(44),						//France
    GB(45),						//United Kingdom
    GE(46),						//Georgia
    GL(47),						//Greenland
    GR(48),						//Greece
    GT(49),						//Guatemala
    HK(50),						//Hong Kong
    HN(51),						//Honduras
    HR(52),						//Croatia
    HT(53),						//Haiti
    HU(54),						//Hungary
    ID(55),						//Indonesia
    IE(56),						//Ireland
    IL(57),						//Israel
    IN(58),						//India
    IQ(59),						//Iraq
    IR(60),						//Iran
    IS(61),						//Iceland
    IT(62),						//Italy
    JM(63),						//Jamaica
    JO(64),						//Jordan
    JP(65),						//Japan
    KE(66),						//Kenya
    KG(67),						//Kyrgyzstan
    KH(68),						//Cambodia
    KR(69),						//Korea
    KW(70),						//Kuwait
    KZ(71),						//Kazakhstan
    LA(72),						//Lao PDR
    LB(73),						//Lebanon
    LI(74),						//Liechtenstein
    LK(75),						//Sri Lanka
    LT(76),						//Lithuania
    LU(77),						//Luxembourg
    LV(78),						//Latvia
    LY(79),						//Libya
    MA(80),						//Morocco
    MC(81),						//Principality of Monaco
    MD(82),						//Moldova
    ME(83),						//Montenegro
    MK(84),						//Macedonia (Former Yugoslav Republic of Macedonia)
    ML(85),						//Mali
    MM(86),						//Myanmar
    MN(87),						//Mongolia
    MO(88),						//Macao SAR
    MT(89),						//Malta
    MV(90),						//Maldives
    MX(91),						//Mexico
    MY(92),						//Malaysia
    NG(93),						//Nigeria
    NI(94),						//Nicaragua
    NL(95),						//Netherlands
    NO(96),						//Norway
    NP(97),						//Nepal
    NZ(98),						//New Zealand
    OM(99),						//Oman
    PA(100),						//Panama
    PE(101),						//Peru
    PH(102),						//Philippines
    PK(103),						//Pakistan
    PL(104),						//Poland
    PR(105),						//Puerto Rico
    PT(106),						//Portugal
    PY(107),						//Paraguay
    QA(108),						//Qatar
    RE(109),						//Réunion
    RO(110),						//Romania
    RS(111),						//Serbia
    RU(112),						//Russia
    RW(113),						//Rwanda
    SA(114),						//Saudi Arabia
    SE(115),						//Sweden
    SG(116),						//Singapore
    SI(117),						//Slovenia
    SK(118),						//Slovakia
    SN(119),						//Senegal
    SO(120),						//Somalia
    SV(121),						//El Salvador
    SY(122),						//Syria
    TH(123),						//Thailand
    TJ(124),						//Tajikistan
    TM(125),						//Turkmenistan
    TN(126),						//Tunisia
    TR(127),						//Turkey
    TT(128),						//Trinidad and Tobago
    TW(129),						//Taiwan
    UA(130),						//Ukraine
    US(131),						//United States
    UY(132),						//Uruguay
    UZ(133),						//Uzbekistan
    VE(134),						//Bolivarian Republic of Venezuela
    VN(135),						//Vietnam
    YE(136),						//Yemen
    ZA(137),						//South Africa
    ZW(138);						//Zimbabwe

	/** The code. */
	private int code;

	/**
	 * Instantiates a new agent country code.
	 *
	 * @param code the code
	 */
	CountryCode(int code) {
		this.code = code;
	}
	/**
	 * Instantiates a new agent country code.
	 *
	 * @param code the code
	 */
	CountryCode() {}
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * Deserialize.
	 *
	 * @param text the text
	 * @return the agent country code
	 * @throws JsonMappingException the json mapping exception
	 */
	public static CountryCode deserialize(String text) throws JsonMappingException {
		try {
			int code = Integer.parseInt(text);
			for (CountryCode countryCode : CountryCode.values()) {
				if (countryCode.getCode() == code)
					return countryCode;
			}
		} catch (Exception e) {
		}
		throw new JsonMappingException("Cannot deserialize " + text + " into a known CountryCode");
	}	
}