  /**
   * Copyright (C) 2016 Securibox
   * 
   * This program is free software: you can redistribute it and/or modify 
   * it under the terms of the GNU General Public License as published by 
   * the Free Software Foundation, either version 3 of the License, or 
   * (at your option) any later version.
   * 
   * This program is distributed in the hope that it will be useful, 
   * but WITHOUT ANY WARRANTY; without even the implied warranty of 
   * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
   * GNU General Public License for more details.
   * 
   * You should have received a copy of the GNU General Public License 
   * along with this program.  If not, see <http://www.gnu.org/licenses/>.
   */

package api.documents.beans;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import api.documents.utils.AgentCountryCodeSerializer;
import api.documents.utils.AgentCountryCodeDeserializer;;

// TODO: Auto-generated Javadoc
/**
 * The Enum AgentCountryCode.
 */
@JsonDeserialize(using = AgentCountryCodeDeserializer.class)
@JsonSerialize(using = AgentCountryCodeSerializer.class)
public enum AgentCountryCode {
	 	
	 	/** The Undefined. */
	 	Undefined(0),
	    
    	/** The global. */
    	GLOBAL(1),
	    
    	/** The af. */
    	AF(4),
	    
    	/** The ax. */
    	AX(248),
	    
    	/** The al. */
    	AL(8),
	    
    	/** The dz. */
    	DZ(12),
	    
    	/** The as. */
    	AS(16),
	    
    	/** The ad. */
    	AD(20),
	    
    	/** The ao. */
    	AO(24),
	    
    	/** The ai. */
    	AI(660),
	    
    	/** The aq. */
    	AQ(10),
	    
    	/** The ag. */
    	AG(28),
	    
    	/** The ar. */
    	AR(32),
	    
    	/** The am. */
    	AM(51),
	    
    	/** The aw. */
    	AW(533),
	    
    	/** The au. */
    	AU(36),
	    
    	/** The at. */
    	AT(40),
	    
    	/** The az. */
    	AZ(31),
	    
    	/** The bs. */
    	BS(44),
	    
    	/** The bh. */
    	BH(48),
	    
    	/** The bd. */
    	BD(50),
	    
    	/** The bb. */
    	BB(52),
	    
    	/** The by. */
    	BY(112),
	    
    	/** The be. */
    	BE(56),
	    
    	/** The bz. */
    	BZ(84),
	    
    	/** The bj. */
    	BJ(204),
	    
    	/** The bm. */
    	BM(60),
	    
    	/** The bt. */
    	BT(64),
	    
    	/** The bo. */
    	BO(68),
	    
    	/** The bq. */
    	BQ(535),
	    
    	/** The ba. */
    	BA(70),
	    
    	/** The bw. */
    	BW(72),
	    
    	/** The bv. */
    	BV(74),
	    
    	/** The br. */
    	BR(76),
	    
    	/** The io. */
    	IO(86),
	    
    	/** The bn. */
    	BN(96),
	    
    	/** The bg. */
    	BG(100),
	    
    	/** The bf. */
    	BF(854),
	    
    	/** The bi. */
    	BI(108),
	    
    	/** The kh. */
    	KH(116),
	    
    	/** The cm. */
    	CM(120),
	    
    	/** The ca. */
    	CA(124),
	    
    	/** The cv. */
    	CV(132),
	    
    	/** The ky. */
    	KY(136),
	    
    	/** The cf. */
    	CF(140),
	    
    	/** The td. */
    	TD(148),
	    
    	/** The cl. */
    	CL(152),
	    
    	/** The cn. */
    	CN(156),
	    
    	/** The cx. */
    	CX(162),
	    
    	/** The cc. */
    	CC(166),
	    
    	/** The co. */
    	CO(170),
	    
    	/** The km. */
    	KM(174),
	    
    	/** The cg. */
    	CG(178),
	    
    	/** The cd. */
    	CD(180),
	    
    	/** The ck. */
    	CK(184),
	    
    	/** The cr. */
    	CR(188),
	    
    	/** The ci. */
    	CI(384),
	    
    	/** The hr. */
    	HR(191),
	    
    	/** The cu. */
    	CU(192),
	    
    	/** The cw. */
    	CW(531),
	    
    	/** The cy. */
    	CY(196),
	    
    	/** The cz. */
    	CZ(203),
	    
    	/** The dk. */
    	DK(208),
	    
    	/** The dj. */
    	DJ(262),
	    
    	/** The dm. */
    	DM(212),
	    
    	/** The do. */
    	DO(214),
	    
    	/** The ec. */
    	EC(218),
	    
    	/** The eg. */
    	EG(818),
	    
    	/** The sv. */
    	SV(222),
	    
    	/** The gq. */
    	GQ(226),
	    
    	/** The er. */
    	ER(232),
	    
    	/** The ee. */
    	EE(233),
	    
    	/** The et. */
    	ET(231),
	    
    	/** The fk. */
    	FK(238),
	    
    	/** The fo. */
    	FO(234),
	    
    	/** The fj. */
    	FJ(242),
	    
    	/** The fi. */
    	FI(246),
	    
    	/** The fr. */
    	FR(250),
	    
    	/** The gf. */
    	GF(254),
	    
    	/** The pf. */
    	PF(258),
	    
    	/** The tf. */
    	TF(260),
	    
    	/** The ga. */
    	GA(266),
	    
    	/** The gm. */
    	GM(270),
	    
    	/** The ge. */
    	GE(268),
	    
    	/** The de. */
    	DE(276),
	    
    	/** The gh. */
    	GH(288),
	    
    	/** The gi. */
    	GI(292),
	    
    	/** The gr. */
    	GR(300),
	    
    	/** The gl. */
    	GL(304),
	    
    	/** The gd. */
    	GD(308),
	    
    	/** The gp. */
    	GP(312),
	    
    	/** The gu. */
    	GU(316),
	    
    	/** The gt. */
    	GT(320),
	    
    	/** The gg. */
    	GG(831),
	    
    	/** The gn. */
    	GN(324),
	    
    	/** The gw. */
    	GW(624),
	    
    	/** The gy. */
    	GY(328),
	    
    	/** The ht. */
    	HT(332),
	    
    	/** The hm. */
    	HM(334),
	    
    	/** The va. */
    	VA(336),
	    
    	/** The hn. */
    	HN(340),
	    
    	/** The hk. */
    	HK(344),
	    
    	/** The hu. */
    	HU(348),
	    
    	/** The is. */
    	IS(352),
	    
    	/** The in. */
    	IN(356),
	    
    	/** The id. */
    	ID(360),
	    
    	/** The ir. */
    	IR(364),
	    
    	/** The iq. */
    	IQ(368),
	    
    	/** The ie. */
    	IE(372),
	    
    	/** The im. */
    	IM(833),
	    
    	/** The il. */
    	IL(376),
	    
    	/** The it. */
    	IT(380),
	    
    	/** The jm. */
    	JM(388),
	    
    	/** The jp. */
    	JP(392),
	    
    	/** The je. */
    	JE(832),
	    
    	/** The jo. */
    	JO(400),
	    
    	/** The kz. */
    	KZ(398),
	    
    	/** The ke. */
    	KE(404),
	    
    	/** The ki. */
    	KI(296),
	    
    	/** The kp. */
    	KP(408),
	    
    	/** The kr. */
    	KR(410),
	    
    	/** The kw. */
    	KW(414),
	    
    	/** The kg. */
    	KG(417),
	    
    	/** The la. */
    	LA(418),
	    
    	/** The lv. */
    	LV(428),
	    
    	/** The lb. */
    	LB(422),
	    
    	/** The ls. */
    	LS(426),
	    
    	/** The lr. */
    	LR(430),
	    
    	/** The ly. */
    	LY(434),
	    
    	/** The li. */
    	LI(438),
	    
    	/** The lt. */
    	LT(440),
	    
    	/** The lu. */
    	LU(442),
	    
    	/** The mo. */
    	MO(446),
	    
    	/** The mk. */
    	MK(807),
	    
    	/** The mg. */
    	MG(450),
	    
    	/** The mw. */
    	MW(454),
	    
    	/** The my. */
    	MY(458),
	    
    	/** The mv. */
    	MV(462),
	    
    	/** The ml. */
    	ML(466),
	    
    	/** The mt. */
    	MT(470),
	    
    	/** The mh. */
    	MH(584),
	    
    	/** The mq. */
    	MQ(474),
	    
    	/** The mr. */
    	MR(478),
	    
    	/** The mu. */
    	MU(480),
	    
    	/** The yt. */
    	YT(175),
	    
    	/** The mx. */
    	MX(484),
	    
    	/** The fm. */
    	FM(583),
	    
    	/** The md. */
    	MD(498),
	    
    	/** The mc. */
    	MC(492),
	    
    	/** The mn. */
    	MN(496),
	    
    	/** The me. */
    	ME(499),
	    
    	/** The ms. */
    	MS(500),
	    
    	/** The ma. */
    	MA(504),
	    
    	/** The mz. */
    	MZ(508),
	    
    	/** The mm. */
    	MM(104),
	    
    	/** The na. */
    	NA(516),
	    
    	/** The nr. */
    	NR(520),
	    
    	/** The np. */
    	NP(524),
	    
    	/** The nl. */
    	NL(528),
	    
    	/** The nc. */
    	NC(540),
	    
    	/** The nz. */
    	NZ(554),
	    
    	/** The ni. */
    	NI(558),
	    
    	/** The ne. */
    	NE(562),
	    
    	/** The ng. */
    	NG(566),
	    
    	/** The nu. */
    	NU(570),
	    
    	/** The nf. */
    	NF(574),
	    
    	/** The mp. */
    	MP(580),
	    
    	/** The no. */
    	NO(578),
	    
    	/** The om. */
    	OM(512),
	    
    	/** The pk. */
    	PK(586),
	    
    	/** The pw. */
    	PW(585),
	    
    	/** The ps. */
    	PS(275),
	    
    	/** The pa. */
    	PA(591),
	    
    	/** The pg. */
    	PG(598),
	    
    	/** The py. */
    	PY(600),
	    
    	/** The pe. */
    	PE(604),
	    
    	/** The ph. */
    	PH(608),
	    
    	/** The pn. */
    	PN(612),
	    
    	/** The pl. */
    	PL(616),
	    
    	/** The pt. */
    	PT(620),
	    
    	/** The pr. */
    	PR(630),
	    
    	/** The qa. */
    	QA(634),
	    
    	/** The re. */
    	RE(638),
	    
    	/** The ro. */
    	RO(642),
	    
    	/** The ru. */
    	RU(643),
	    
    	/** The rw. */
    	RW(646),
	    
    	/** The bl. */
    	BL(652),
	    
    	/** The sh. */
    	SH(654),
	    
    	/** The kn. */
    	KN(659),
	    
    	/** The lc. */
    	LC(662),
	    
    	/** The mf. */
    	MF(663),
	    
    	/** The pm. */
    	PM(666),
	    
    	/** The vc. */
    	VC(670),
	    
    	/** The ws. */
    	WS(882),
	    
    	/** The sm. */
    	SM(674),
	    
    	/** The st. */
    	ST(678),
	    
    	/** The sa. */
    	SA(682),
	    
    	/** The sn. */
    	SN(686),
	    
    	/** The rs. */
    	RS(688),
	    
    	/** The sc. */
    	SC(690),
	    
    	/** The sl. */
    	SL(694),
	    
    	/** The sg. */
    	SG(702),
	    
    	/** The sx. */
    	SX(534),
	    
    	/** The sk. */
    	SK(703),
	    
    	/** The si. */
    	SI(705),
	    
    	/** The sb. */
    	SB(90),
	    
    	/** The so. */
    	SO(706),
	    
    	/** The za. */
    	ZA(710),
	    
    	/** The gs. */
    	GS(239),
	    
    	/** The ss. */
    	SS(728),
	    
    	/** The es. */
    	ES(724),
	    
    	/** The lk. */
    	LK(144),
	    
    	/** The sd. */
    	SD(729),
	    
    	/** The sr. */
    	SR(740),
	    
    	/** The sj. */
    	SJ(744),
	    
    	/** The sz. */
    	SZ(748),
	    
    	/** The se. */
    	SE(752),
	    
    	/** The ch. */
    	CH(756),
	    
    	/** The sy. */
    	SY(760),
	    
    	/** The tw. */
    	TW(158),
	    
    	/** The tj. */
    	TJ(762),
	    
    	/** The tz. */
    	TZ(834),
	    
    	/** The th. */
    	TH(764),
	    
    	/** The tl. */
    	TL(626),
	    
    	/** The tg. */
    	TG(768),
	    
    	/** The tk. */
    	TK(772),
	    
    	/** The to. */
    	TO(776),
	    
    	/** The tt. */
    	TT(780),
	    
    	/** The tn. */
    	TN(788),
	    
    	/** The tr. */
    	TR(792),
	    
    	/** The tm. */
    	TM(795),
	    
    	/** The tc. */
    	TC(796),
	    
    	/** The tv. */
    	TV(798),
	    
    	/** The ug. */
    	UG(800),
	    
    	/** The ua. */
    	UA(804),
	    
    	/** The ae. */
    	AE(784),
	    
    	/** The gb. */
    	GB(826),
	    
    	/** The us. */
    	US(840),
	    
    	/** The um. */
    	UM(581),
	    
    	/** The uy. */
    	UY(858),
	    
    	/** The uz. */
    	UZ(860),
	    
    	/** The vu. */
    	VU(548),
	    
    	/** The ve. */
    	VE(862),
	    
    	/** The vn. */
    	VN(704),
	    
    	/** The vg. */
    	VG(92),
	    
    	/** The vi. */
    	VI(850),
	    
    	/** The wf. */
    	WF(876),
	    
    	/** The eh. */
    	EH(732),
	    
    	/** The ye. */
    	YE(887),
	    
    	/** The zm. */
    	ZM(894),
	    
    	/** The zw. */
    	ZW(716);

	/** The code. */
	private int code;

	/**
	 * Instantiates a new agent country code.
	 *
	 * @param code the code
	 */
	AgentCountryCode(int code) {
		this.code = code;
	}

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
	public static AgentCountryCode deserialize(String text) throws JsonMappingException {
		try {
			int code = Integer.parseInt(text);
			for (AgentCountryCode countryCode : AgentCountryCode.values()) {
				if (countryCode.getCode() == code)
					return countryCode;
			}
		} catch (Exception e) {
		}
		throw new JsonMappingException("Cannot deserialize " + text + " into a known AgentCountryCode");
	}	
}
