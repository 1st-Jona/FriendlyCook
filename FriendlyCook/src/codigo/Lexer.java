/* The following code was generated by JFlex 1.4.3 on 4/01/21 07:33 PM */

package codigo;
import static codigo.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 4/01/21 07:33 PM from the specification file
 * <tt>C:/FriendlyCook/FriendlyCook/src/codigo/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\2\1\56\2\0\1\2\22\0\1\4\7\0\1\57\1\61"+
    "\2\0\1\3\1\60\1\0\1\55\12\1\7\0\1\12\7\0\1\15"+
    "\1\14\1\0\1\42\1\17\1\13\1\27\1\0\1\32\1\0\1\5"+
    "\7\0\4\0\2\0\1\6\1\50\1\34\1\40\1\23\1\53\1\51"+
    "\1\33\1\11\1\10\1\52\1\35\1\24\1\7\1\25\1\37\1\30"+
    "\1\20\1\16\1\22\1\31\1\21\1\0\1\54\1\26\1\36\146\0"+
    "\1\41\7\0\1\44\3\0\1\46\3\0\1\43\1\0\1\47\6\0"+
    "\1\45\uff05\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\13\1\1\4\16\1\1\5"+
    "\20\0\1\6\11\0\1\7\10\0\1\10\11\0\1\11"+
    "\7\0\1\3\17\0\1\12\15\0\1\13\2\0\1\14"+
    "\17\0\1\15\3\0\1\16\4\0\1\17\3\0\1\20"+
    "\13\0\1\21\1\0\1\22\6\0\1\23\1\24\6\0"+
    "\1\25\2\0\1\26\1\27\10\0\1\30\16\0\1\23"+
    "\1\31\1\0\1\32\4\0\1\2\1\33\1\34\1\0"+
    "\1\35\1\36\3\0\1\37\2\0\1\40\14\0\1\41"+
    "\2\0\1\42\6\0\1\43\1\0\1\44\2\0\1\45"+
    "\2\0\1\46\20\0\1\47\1\50\5\0\1\51\1\0"+
    "\1\52\1\53\5\0\1\54\6\0\1\55\5\0\1\56"+
    "\7\0\1\57\3\0\1\60\3\0\1\61\1\0\1\62"+
    "\3\0\1\63\1\0\1\64\1\65\1\66\1\0\1\67"+
    "\1\0\1\70\5\0\1\71\1\72\6\0\1\73\2\0"+
    "\1\74\1\75\5\0\1\76\16\0\1\77\6\0\1\100"+
    "\3\0\1\101\1\102\3\0\1\103\3\0\1\104\1\0"+
    "\1\105\5\0\1\106\1\107\1\110\10\0\1\111\1\112"+
    "\5\0\1\113\1\0\1\114\3\0\1\115\1\116";

  private static int [] zzUnpackAction() {
    int [] result = new int[424];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\310\0\372\0\u012c\0\u015e"+
    "\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\u028a\0\u02bc\0\u02ee"+
    "\0\62\0\u0320\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c"+
    "\0\u047e\0\u04b0\0\u04e2\0\u0514\0\u0546\0\u0578\0\u05aa\0\226"+
    "\0\u05dc\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6\0\u0708\0\u073a"+
    "\0\u076c\0\u079e\0\u07d0\0\u0802\0\u0834\0\u0866\0\u0898\0\u08ca"+
    "\0\62\0\u08fc\0\u092e\0\u0960\0\u0992\0\u09c4\0\u09f6\0\u0a28"+
    "\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0\0\u0b22\0\u0b54\0\u0b86\0\u0bb8"+
    "\0\u0bea\0\u0c1c\0\u0c4e\0\u0c80\0\u0cb2\0\u0ce4\0\u0d16\0\u0d48"+
    "\0\u0d7a\0\u0dac\0\u0dde\0\u0e10\0\u0e42\0\62\0\u0e74\0\u0ea6"+
    "\0\u0ed8\0\u0f0a\0\u0f3c\0\u0f6e\0\u0fa0\0\u0fd2\0\u1004\0\u1036"+
    "\0\u1068\0\u109a\0\u10cc\0\u10fe\0\u1130\0\u1162\0\u1194\0\u11c6"+
    "\0\u11f8\0\u122a\0\u125c\0\u128e\0\u12c0\0\62\0\u12f2\0\u1324"+
    "\0\u1356\0\u1388\0\u13ba\0\u13ec\0\u141e\0\u1450\0\u1482\0\u14b4"+
    "\0\u14e6\0\u1518\0\u154a\0\62\0\u157c\0\u15ae\0\62\0\u15e0"+
    "\0\u1612\0\u1644\0\u1676\0\u16a8\0\u16da\0\u170c\0\u173e\0\u1770"+
    "\0\u17a2\0\u17d4\0\u1806\0\u1838\0\u186a\0\u189c\0\62\0\u18ce"+
    "\0\u1900\0\u1932\0\62\0\u1964\0\u1996\0\u19c8\0\u19fa\0\62"+
    "\0\u1a2c\0\u1a5e\0\u1a90\0\62\0\u1ac2\0\u1af4\0\u1b26\0\u1b58"+
    "\0\u1b8a\0\u1bbc\0\u1bee\0\u1c20\0\u1c52\0\u1c84\0\u1cb6\0\62"+
    "\0\u1ce8\0\62\0\u1d1a\0\u1d4c\0\u1d7e\0\u1db0\0\u1de2\0\u1e14"+
    "\0\u0e10\0\62\0\u1e46\0\u1e78\0\u1eaa\0\u1edc\0\u1f0e\0\u1f40"+
    "\0\62\0\u1f72\0\u1fa4\0\62\0\62\0\u1fd6\0\u2008\0\u203a"+
    "\0\u206c\0\u209e\0\u20d0\0\u2102\0\u2134\0\62\0\u2166\0\u2198"+
    "\0\u21ca\0\u21fc\0\u222e\0\u2260\0\u2292\0\u22c4\0\u22f6\0\u2328"+
    "\0\u235a\0\u238c\0\u23be\0\u23f0\0\62\0\62\0\u2422\0\62"+
    "\0\u2454\0\u2486\0\u24b8\0\u24ea\0\62\0\62\0\62\0\u251c"+
    "\0\62\0\62\0\u254e\0\u2580\0\u25b2\0\62\0\u25e4\0\u2616"+
    "\0\62\0\u2648\0\u267a\0\u26ac\0\u26de\0\u2710\0\u2742\0\u2774"+
    "\0\u27a6\0\u27d8\0\u280a\0\u283c\0\u286e\0\62\0\u28a0\0\u28d2"+
    "\0\62\0\u2904\0\u2936\0\u2968\0\u299a\0\u29cc\0\u29fe\0\62"+
    "\0\u2a30\0\62\0\u2a62\0\u2a94\0\62\0\u2ac6\0\u2af8\0\62"+
    "\0\u2b2a\0\u2b5c\0\u2b8e\0\u2bc0\0\u2bf2\0\u2c24\0\u2c56\0\u2c88"+
    "\0\u2cba\0\u2cec\0\u2d1e\0\u2d50\0\u2d82\0\u2db4\0\u2de6\0\u2e18"+
    "\0\62\0\62\0\u2e4a\0\u2e7c\0\u2eae\0\u2ee0\0\u2f12\0\62"+
    "\0\u2f44\0\62\0\62\0\u2f76\0\u2fa8\0\u2fda\0\u300c\0\u303e"+
    "\0\62\0\u3070\0\u30a2\0\u30d4\0\u3106\0\u3138\0\u316a\0\62"+
    "\0\u319c\0\u31ce\0\u3200\0\u3232\0\u3264\0\62\0\u3296\0\u32c8"+
    "\0\u32fa\0\u332c\0\u335e\0\u3390\0\u33c2\0\62\0\u33f4\0\u3426"+
    "\0\u3458\0\62\0\u348a\0\u34bc\0\u34ee\0\62\0\u3520\0\62"+
    "\0\u3552\0\u3584\0\u35b6\0\62\0\u35e8\0\62\0\62\0\62"+
    "\0\u361a\0\62\0\u364c\0\62\0\u367e\0\u36b0\0\u36e2\0\u3714"+
    "\0\u3746\0\62\0\62\0\u3778\0\u37aa\0\u37dc\0\u380e\0\u3840"+
    "\0\u3872\0\62\0\u38a4\0\u38d6\0\62\0\62\0\u3908\0\u393a"+
    "\0\u396c\0\u399e\0\u39d0\0\62\0\u3a02\0\u3a34\0\u3a66\0\u3a98"+
    "\0\u3aca\0\u3afc\0\u3b2e\0\u3b60\0\u3b92\0\u3bc4\0\u3bf6\0\u3c28"+
    "\0\u3c5a\0\u3c8c\0\62\0\u3cbe\0\u3cf0\0\u3d22\0\u3d54\0\u3d86"+
    "\0\u3db8\0\62\0\u3dea\0\u3e1c\0\u3e4e\0\62\0\62\0\u3e80"+
    "\0\u3eb2\0\u3ee4\0\62\0\u3f16\0\u3f48\0\u3f7a\0\62\0\u3fac"+
    "\0\62\0\u3fde\0\u4010\0\u4042\0\u4074\0\u40a6\0\62\0\62"+
    "\0\62\0\u40d8\0\u410a\0\u413c\0\u416e\0\u41a0\0\u41d2\0\u4204"+
    "\0\u4236\0\62\0\62\0\u4268\0\u429a\0\u42cc\0\u42fe\0\u4330"+
    "\0\62\0\u4362\0\62\0\u4394\0\u43c6\0\u43f8\0\62\0\62";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[424];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\4\1\6\1\7\1\10"+
    "\1\11\1\2\1\7\3\2\1\12\1\13\1\2\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\2\1\31\1\32\1\2"+
    "\1\33\5\2\1\34\2\2\1\35\1\2\1\36\1\4"+
    "\1\37\2\2\63\0\1\3\62\0\3\4\51\0\1\4"+
    "\5\0\2\4\1\40\51\0\1\4\11\0\1\41\3\0"+
    "\1\42\107\0\1\43\27\0\1\44\22\0\1\45\61\0"+
    "\1\46\36\0\1\41\2\0\1\47\11\0\1\50\5\0"+
    "\1\51\36\0\1\52\61\0\1\53\2\0\1\54\11\0"+
    "\1\55\56\0\1\56\2\0\1\57\45\0\1\60\25\0"+
    "\1\61\16\0\1\62\13\0\1\63\2\0\1\64\11\0"+
    "\1\65\5\0\1\66\37\0\1\67\16\0\1\70\5\0"+
    "\1\71\53\0\1\70\64\0\1\72\37\0\1\73\103\0"+
    "\1\74\36\0\1\75\14\0\1\76\44\0\1\77\2\0"+
    "\1\100\13\0\1\101\3\0\1\102\1\0\1\103\34\0"+
    "\1\104\2\0\1\105\11\0\1\106\1\0\1\107\16\0"+
    "\1\106\23\0\1\110\2\0\1\111\11\0\1\112\1\0"+
    "\1\113\42\0\1\114\2\0\1\115\11\0\1\116\1\0"+
    "\1\117\20\0\1\120\24\0\1\121\75\0\1\122\42\0"+
    "\1\123\11\0\1\124\4\0\1\125\111\0\1\126\64\0"+
    "\1\127\10\0\1\130\65\0\1\131\57\0\1\132\70\0"+
    "\1\133\64\0\1\134\107\0\1\135\33\0\1\136\47\0"+
    "\1\137\6\0\1\140\57\0\1\141\63\0\1\142\57\0"+
    "\1\143\5\0\1\144\71\0\1\145\45\0\1\146\47\0"+
    "\1\147\14\0\1\150\15\0\1\151\27\0\1\152\10\0"+
    "\1\153\57\0\1\154\102\0\1\155\42\0\1\156\61\0"+
    "\1\157\50\0\1\160\6\0\1\161\66\0\1\162\20\0"+
    "\1\162\51\0\1\163\50\0\1\164\71\0\1\165\37\0"+
    "\1\166\56\0\1\167\64\0\1\170\74\0\1\171\7\0"+
    "\1\172\62\0\1\173\44\0\1\174\1\0\1\175\1\0"+
    "\1\176\26\0\1\177\15\0\1\200\72\0\1\201\13\0"+
    "\1\202\33\0\1\203\14\0\1\204\10\0\1\205\56\0"+
    "\1\206\46\0\1\207\61\0\1\210\5\0\1\211\60\0"+
    "\1\212\54\0\1\213\71\0\1\214\76\0\1\215\55\0"+
    "\1\216\1\217\41\0\1\220\65\0\1\221\60\0\1\222"+
    "\10\0\1\223\43\0\1\224\15\0\1\225\61\0\1\223"+
    "\43\0\1\210\67\0\1\226\56\0\1\227\71\0\1\230"+
    "\37\0\1\231\52\0\56\126\1\0\3\126\1\0\1\232"+
    "\70\0\1\233\65\0\1\234\72\0\1\235\21\0\1\235"+
    "\20\0\1\236\74\0\1\237\65\0\1\240\56\0\1\241"+
    "\55\0\1\242\64\0\1\243\73\0\1\244\47\0\1\245"+
    "\65\0\1\246\73\0\1\247\44\0\1\250\62\0\1\251"+
    "\54\0\1\252\15\0\1\253\50\0\1\114\61\0\1\254"+
    "\47\0\1\255\73\0\1\256\56\0\1\257\63\0\1\260"+
    "\45\0\1\55\104\0\1\261\13\0\1\261\22\0\1\262"+
    "\71\0\1\263\66\0\1\264\63\0\1\265\43\0\1\266"+
    "\13\0\1\267\61\0\1\267\106\0\1\270\34\0\1\271"+
    "\44\0\1\272\75\0\1\273\64\0\1\274\42\0\1\275"+
    "\76\0\1\276\72\0\1\277\52\0\1\300\42\0\1\301"+
    "\75\0\1\302\46\0\1\303\105\0\1\304\46\0\1\305"+
    "\63\0\1\306\64\0\1\307\60\0\1\310\41\0\1\311"+
    "\63\0\1\312\71\0\1\313\54\0\1\314\73\0\1\315"+
    "\74\0\1\316\45\0\1\317\62\0\1\320\106\0\1\321"+
    "\36\0\1\322\56\0\1\323\77\0\1\324\22\0\1\232"+
    "\57\0\1\325\11\0\1\326\65\0\1\326\62\0\1\327"+
    "\52\0\1\330\75\0\1\331\61\0\1\332\47\0\1\333"+
    "\61\0\1\334\61\0\1\335\66\0\1\336\54\0\1\337"+
    "\75\0\1\340\57\0\1\341\76\0\1\342\47\0\1\343"+
    "\76\0\1\344\41\0\1\345\47\0\1\346\34\0\1\346"+
    "\17\0\1\347\77\0\1\350\73\0\1\351\45\0\1\352"+
    "\72\0\1\353\50\0\1\354\101\0\1\355\27\0\1\356"+
    "\73\0\1\357\61\0\1\360\66\0\1\361\43\0\1\362"+
    "\56\0\1\363\75\0\1\364\63\0\1\365\45\0\1\366"+
    "\73\0\1\367\66\0\1\370\43\0\1\371\75\0\1\372"+
    "\76\0\1\373\25\0\1\374\66\0\1\375\110\0\1\376"+
    "\27\0\1\212\61\0\1\377\73\0\1\u0100\47\0\1\u0101"+
    "\61\0\1\u0102\63\0\1\u0103\106\0\1\u0104\30\0\1\u0105"+
    "\64\0\1\326\72\0\1\u0106\61\0\1\u0107\66\0\1\u0108"+
    "\42\0\1\u0109\61\0\1\u010a\71\0\1\u010b\52\0\1\u010c"+
    "\74\0\1\u010d\6\0\1\u010e\2\0\1\u010f\3\0\1\u0110"+
    "\41\0\1\344\64\0\1\u0111\63\0\1\u0112\54\0\1\u0113"+
    "\44\0\1\u0114\103\0\1\u0115\70\0\1\u0116\52\0\1\u0117"+
    "\42\0\1\u0118\107\0\1\u0119\52\0\1\u011a\42\0\1\u011b"+
    "\73\0\1\u011c\66\0\1\u011d\42\0\1\u011e\76\0\1\u011f"+
    "\72\0\1\u0120\52\0\1\u0121\72\0\1\u0122\27\0\1\u0123"+
    "\64\0\1\u0124\60\0\1\u0125\110\0\1\u0126\64\0\1\u0127"+
    "\46\0\1\u0128\45\0\1\u0129\70\0\1\u012a\113\0\1\u012b"+
    "\33\0\1\u012c\53\0\1\u012d\54\0\1\u012e\70\0\1\u012f"+
    "\50\0\1\u0130\103\0\1\u0131\55\0\1\u0132\105\0\1\u0133"+
    "\30\0\1\u0134\45\0\1\u0135\100\0\1\u0136\45\0\1\u0137"+
    "\77\0\1\u0138\42\0\1\u0139\71\0\1\u013a\103\0\1\u013b"+
    "\25\0\1\u013c\102\0\1\u013d\61\0\1\u013e\57\0\1\u013f"+
    "\60\0\1\u0140\77\0\1\u0141\44\0\1\u0142\61\0\1\u0143"+
    "\44\0\1\u0144\76\0\1\u0145\47\0\1\u0146\73\0\1\u0147"+
    "\63\0\1\u0148\57\0\1\u0149\63\0\1\u014a\42\0\1\u014b"+
    "\71\0\1\u014c\74\0\1\u014d\53\0\1\u014e\76\0\1\u014f"+
    "\32\0\1\u0150\105\0\1\u0151\42\0\1\u0152\51\0\1\u0153"+
    "\77\0\1\u0154\3\0\1\u0155\4\0\1\u0156\15\0\1\u0157"+
    "\43\0\1\u0158\33\0\1\u0159\60\0\1\u015a\75\0\1\u015b"+
    "\43\0\1\u015c\73\0\1\u015d\61\0\1\u015e\65\0\1\u015f"+
    "\62\0\1\u0160\44\0\1\u0161\76\0\1\u0162\60\0\1\u0163"+
    "\45\0\1\u0164\100\0\1\u0165\65\0\1\u0166\41\0\1\u0167"+
    "\70\0\1\u0168\47\0\1\u0169\57\0\1\u016a\63\0\1\u016b"+
    "\73\0\1\u016c\13\0\1\u016d\2\0\1\u016e\42\0\1\u016f"+
    "\57\0\1\u0170\100\0\1\u0171\30\0\1\u0172\102\0\1\u0173"+
    "\54\0\1\u0174\64\0\1\u0175\62\0\1\u0176\60\0\1\u0177"+
    "\76\0\1\u0178\55\0\1\u0179\43\0\1\u017a\66\0\1\u017b"+
    "\44\0\1\u017c\100\0\1\u017d\61\0\1\u017e\42\0\1\u017f"+
    "\64\0\1\u0180\71\0\1\u0181\12\0\1\u0182\33\0\1\u0183"+
    "\71\0\1\u0184\70\0\1\u0185\21\0\1\u0185\30\0\1\u0186"+
    "\51\0\1\u0187\61\0\1\u0188\71\0\1\u0189\67\0\1\u018a"+
    "\72\0\1\u018b\62\0\1\u018c\31\0\1\u018d\61\0\1\u018e"+
    "\100\0\1\u018f\43\0\1\u0190\60\0\1\u0191\73\0\1\u0192"+
    "\47\0\1\u0193\110\0\1\u0194\32\0\1\u0195\64\0\1\u0196"+
    "\104\0\1\u0197\33\0\1\u0198\73\0\1\u0199\66\0\1\u019a"+
    "\54\0\1\u019b\50\0\1\u019c\60\0\1\u019d\77\0\1\u019e"+
    "\62\0\1\u019f\21\0\1\u019f\23\0\1\u01a0\75\0\1\u01a1"+
    "\57\0\1\u01a2\45\0\1\u01a3\107\0\1\u01a4\61\0\1\u01a5"+
    "\61\0\1\u01a6\51\0\1\u01a7\42\0\1\u01a8\53\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[17450];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\16\1\1\11\17\1\20\0\1\11\11\0"+
    "\1\1\10\0\1\1\11\0\1\11\7\0\1\1\17\0"+
    "\1\11\15\0\1\11\2\0\1\11\17\0\1\11\3\0"+
    "\1\11\4\0\1\11\3\0\1\11\13\0\1\11\1\0"+
    "\1\11\6\0\1\1\1\11\6\0\1\11\2\0\2\11"+
    "\10\0\1\11\16\0\2\11\1\0\1\11\4\0\3\11"+
    "\1\0\2\11\3\0\1\11\2\0\1\11\14\0\1\11"+
    "\2\0\1\11\6\0\1\11\1\0\1\11\2\0\1\11"+
    "\2\0\1\11\20\0\2\11\5\0\1\11\1\0\2\11"+
    "\5\0\1\11\6\0\1\11\5\0\1\11\7\0\1\11"+
    "\3\0\1\11\3\0\1\11\1\0\1\11\3\0\1\11"+
    "\1\0\3\11\1\0\1\11\1\0\1\11\5\0\2\11"+
    "\6\0\1\11\2\0\2\11\5\0\1\11\16\0\1\11"+
    "\6\0\1\11\3\0\2\11\3\0\1\11\3\0\1\11"+
    "\1\0\1\11\5\0\3\11\10\0\2\11\5\0\1\11"+
    "\1\0\1\11\3\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[424];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 144) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 43: 
          { lexeme=yytext(); return CUENTA;
          }
        case 79: break;
        case 59: 
          { lexeme=yytext(); return NARANJADA;
          }
        case 80: break;
        case 48: 
          { lexeme=yytext(); return CHURROS;
          }
        case 81: break;
        case 52: 
          { lexeme=yytext(); return TERIYAKI;
          }
        case 82: break;
        case 6: 
          { lexeme=yytext(); return EL;
          }
        case 83: break;
        case 23: 
          { lexeme=yytext(); return OCHO;
          }
        case 84: break;
        case 29: 
          { lexeme=yytext(); return NUEVE;
          }
        case 85: break;
        case 71: 
          { lexeme=yytext(); return PIE_LIMON;
          }
        case 86: break;
        case 77: 
          { lexeme=yytext(); return FRUTA_CARAMELO;
          }
        case 87: break;
        case 22: 
          { lexeme=yytext(); return ONCE;
          }
        case 88: break;
        case 70: 
          { lexeme=yytext(); return PIE_QUESO;
          }
        case 89: break;
        case 64: 
          { lexeme=yytext(); return SERVILLETAS;
          }
        case 90: break;
        case 65: 
          { lexeme=yytext(); return MESAD;
          }
        case 91: break;
        case 76: 
          { lexeme=yytext(); return SUSHI_CAMARON;
          }
        case 92: break;
        case 37: 
          { lexeme=yytext(); return PEPSI;
          }
        case 93: break;
        case 50: 
          { lexeme=yytext(); return FONDANT;
          }
        case 94: break;
        case 33: 
          { lexeme=yytext(); return CARTA;
          }
        case 95: break;
        case 32: 
          { lexeme=yytext(); return TRECE;
          }
        case 96: break;
        case 3: 
          { /*Ignore*/
          }
        case 97: break;
        case 30: 
          { lexeme=yytext(); return SIETE;
          }
        case 98: break;
        case 9: 
          { lexeme=yytext(); return DE;
          }
        case 99: break;
        case 26: 
          { lexeme=yytext(); return DOCE;
          }
        case 100: break;
        case 72: 
          { lexeme=yytext(); return PIE_FRESA;
          }
        case 101: break;
        case 40: 
          { lexeme=yytext(); return QUIERO;
          }
        case 102: break;
        case 12: 
          { lexeme=yytext(); return CANT_UNA;
          }
        case 103: break;
        case 36: 
          { lexeme=yytext(); return LEER;
          }
        case 104: break;
        case 74: 
          { lexeme=yytext(); return HACER;
          }
        case 105: break;
        case 13: 
          { lexeme=yytext(); return LAS;
          }
        case 106: break;
        case 61: 
          { lexeme=yytext(); return MESAC;
          }
        case 107: break;
        case 28: 
          { lexeme=yytext(); return ADIOS;
          }
        case 108: break;
        case 21: 
          { lexeme=yytext(); return MENU;
          }
        case 109: break;
        case 47: 
          { lexeme=yytext(); return CATORCE;
          }
        case 110: break;
        case 63: 
          { lexeme=yytext(); return CAMARONITO;
          }
        case 111: break;
        case 53: 
          { lexeme=yytext(); return MOSTRAR;
          }
        case 112: break;
        case 1: 
          { return ERROR;
          }
        case 113: break;
        case 44: 
          { lexeme=yytext(); return PEDIDO;
          }
        case 114: break;
        case 5: 
          { lexeme=yytext(); return Coma;
          }
        case 115: break;
        case 60: 
          { lexeme=yytext(); return TENEDORES;
          }
        case 116: break;
        case 31: 
          { lexeme=yytext(); return VASOS;
          }
        case 117: break;
        case 56: 
          { lexeme=yytext(); return MESAB;
          }
        case 118: break;
        case 4: 
          { lexeme=yytext(); return Y;
          }
        case 119: break;
        case 17: 
          { lexeme=yytext(); return JUGO;
          }
        case 120: break;
        case 46: 
          { lexeme=yytext(); return MARTINI;
          }
        case 121: break;
        case 67: 
          { lexeme=yytext(); return PIE_MORA;
          }
        case 122: break;
        case 58: 
          { lexeme=yytext(); return LIMONADA;
          }
        case 123: break;
        case 25: 
          { lexeme=yytext(); return DIEZ;
          }
        case 124: break;
        case 10: 
          { lexeme=yytext(); return VER;
          }
        case 125: break;
        case 39: 
          { lexeme=yytext(); return QUINCE;
          }
        case 126: break;
        case 8: 
          { lexeme=yytext(); return LA;
          }
        case 127: break;
        case 38: 
          { lexeme = yytext(); return FAVOR;
          }
        case 128: break;
        case 27: 
          { lexeme=yytext(); return SANJI;
          }
        case 129: break;
        case 45: 
          { lexeme=yytext(); return VAMPIRO;
          }
        case 130: break;
        case 55: 
          { lexeme=yytext(); return MESAA;
          }
        case 131: break;
        case 68: 
          { lexeme=yytext(); return PIÑA_COLADA;
          }
        case 132: break;
        case 16: 
          { lexeme=yytext(); return DOS;
          }
        case 133: break;
        case 2: 
          { lexeme=yytext(); return Numero;
          }
        case 134: break;
        case 54: 
          { lexeme=yytext(); return EXPRESSO;
          }
        case 135: break;
        case 18: 
          { lexeme=yytext(); return SEIS;
          }
        case 136: break;
        case 42: 
          { lexeme=yytext(); return CUATRO;
          }
        case 137: break;
        case 78: 
          { lexeme=yytext(); return HELADO_VAINILLA;
          }
        case 138: break;
        case 57: 
          { lexeme=yytext(); return CUCHARAS;
          }
        case 139: break;
        case 15: 
          { lexeme = yytext(); return POR;
          }
        case 140: break;
        case 66: 
          { lexeme=yytext(); return HAMBURGUESA_ARROZ;
          }
        case 141: break;
        case 7: 
          { lexeme=yytext(); return CANT_UN;
          }
        case 142: break;
        case 41: 
          { lexeme=yytext(); return CORONA;
          }
        case 143: break;
        case 34: 
          { lexeme=yytext(); return CINCO;
          }
        case 144: break;
        case 35: 
          { lexeme=yytext(); return LISTO;
          }
        case 145: break;
        case 62: 
          { lexeme=yytext(); return COCA_COLA;
          }
        case 146: break;
        case 14: 
          { lexeme=yytext(); return LOS;
          }
        case 147: break;
        case 73: 
          { lexeme=yytext(); return SUSHI_POLLO;
          }
        case 148: break;
        case 11: 
          { lexeme=yytext(); return OYE;
          }
        case 149: break;
        case 75: 
          { lexeme=yytext(); return HELADO_CACAO;
          }
        case 150: break;
        case 69: 
          { lexeme=yytext(); return SUSHI_RES;
          }
        case 151: break;
        case 49: 
          { lexeme=yytext(); return BOMBAZO;
          }
        case 152: break;
        case 19: 
          { lexeme=yytext(); return TRAER;
          }
        case 153: break;
        case 24: 
          { lexeme=yytext(); return CAFE;
          }
        case 154: break;
        case 20: 
          { lexeme=yytext(); return TRES;
          }
        case 155: break;
        case 51: 
          { lexeme=yytext(); return VICTORIA;
          }
        case 156: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
