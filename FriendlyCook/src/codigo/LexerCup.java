/* The following code was generated by JFlex 1.4.3 on 7/01/21 11:24 PM */


package codigo;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 7/01/21 11:24 PM from the specification file
 * <tt>C:/FriendlyCook/FriendlyCook/src/codigo/LexerCup.flex</tt>
 */
class LexerCup implements java_cup.runtime.Scanner {

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
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1, 45,  0,  0,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  2,  0,  0, 44, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  9,  0,  0,  0,  0,  0,  0,  0, 12, 11,  0, 33, 14, 10, 22, 
     0, 25,  0,  4,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  5, 38, 27, 31, 18, 41, 39, 26,  8,  7, 40, 28, 19,  6, 20, 
    30, 23, 15, 13, 17, 24, 16,  0, 43, 21, 29,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0, 32,  0,  0,  0,  0,  0,  0,  0, 35,  0,  0,  0, 37,  0,  0, 
     0, 34,  0, 42,  0,  0,  0,  0,  0,  0, 36,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\14\1\1\3\15\1\1\4\21\0"+
    "\1\5\11\0\1\6\10\0\1\7\11\0\1\10\7\0"+
    "\1\2\17\0\1\11\15\0\1\12\2\0\1\13\17\0"+
    "\1\14\3\0\1\15\4\0\1\16\3\0\1\17\12\0"+
    "\1\20\1\0\1\21\7\0\1\22\1\23\6\0\1\24"+
    "\2\0\1\25\1\26\10\0\1\27\16\0\1\22\1\30"+
    "\1\0\1\31\4\0\1\32\1\33\1\0\1\34\1\35"+
    "\4\0\1\36\2\0\1\37\12\0\1\40\1\0\1\41"+
    "\2\0\1\42\6\0\1\43\1\0\1\44\2\0\1\45"+
    "\2\0\1\46\21\0\1\47\1\50\4\0\1\51\1\0"+
    "\1\52\1\53\5\0\1\54\6\0\1\55\5\0\1\56"+
    "\6\0\1\57\3\0\1\60\3\0\1\61\1\0\1\62"+
    "\3\0\1\63\1\0\1\64\1\65\1\66\1\0\1\67"+
    "\1\0\1\70\4\0\1\71\1\72\6\0\1\73\2\0"+
    "\1\74\1\75\4\0\1\76\15\0\1\77\6\0\1\100"+
    "\3\0\1\101\1\102\2\0\1\103\3\0\1\104\1\0"+
    "\1\105\4\0\1\106\1\107\1\110\7\0\1\111\5\0"+
    "\1\112\1\0\1\113\3\0\1\114\1\115";

  private static int [] zzUnpackAction() {
    int [] result = new int[416];
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
    "\0\0\0\56\0\134\0\212\0\270\0\346\0\u0114\0\u0142"+
    "\0\u0170\0\u019e\0\u01cc\0\u01fa\0\u0228\0\u0256\0\u0284\0\u02b2"+
    "\0\56\0\u02e0\0\u030e\0\u033c\0\u036a\0\u0398\0\u03c6\0\u03f4"+
    "\0\u0422\0\u0450\0\u047e\0\u04ac\0\u04da\0\u0508\0\134\0\u0536"+
    "\0\u0564\0\u0592\0\u05c0\0\u05ee\0\u061c\0\u064a\0\u0678\0\u06a6"+
    "\0\u06d4\0\u0702\0\u0730\0\u075e\0\u078c\0\u07ba\0\u07e8\0\u0816"+
    "\0\56\0\u0844\0\u0872\0\u08a0\0\u08ce\0\u08fc\0\u092a\0\u0958"+
    "\0\u0986\0\u09b4\0\u09e2\0\u0a10\0\u0a3e\0\u0a6c\0\u0a9a\0\u0ac8"+
    "\0\u0af6\0\u0b24\0\u0b52\0\u0b80\0\u0bae\0\u0bdc\0\u0c0a\0\u0c38"+
    "\0\u0c66\0\u0c94\0\u0cc2\0\u0cf0\0\u0d1e\0\56\0\u0d4c\0\u0d7a"+
    "\0\u0da8\0\u0dd6\0\u0e04\0\u0e32\0\u0e60\0\u0e8e\0\u0ebc\0\u0eea"+
    "\0\u0f18\0\u0f46\0\u0f74\0\u0fa2\0\u0fd0\0\u0ffe\0\u102c\0\u105a"+
    "\0\u1088\0\u10b6\0\u10e4\0\u1112\0\u1140\0\56\0\u116e\0\u119c"+
    "\0\u11ca\0\u11f8\0\u1226\0\u1254\0\u1282\0\u12b0\0\u12de\0\u130c"+
    "\0\u133a\0\u1368\0\u1396\0\56\0\u13c4\0\u13f2\0\56\0\u1420"+
    "\0\u144e\0\u147c\0\u14aa\0\u14d8\0\u1506\0\u1534\0\u1562\0\u1590"+
    "\0\u15be\0\u15ec\0\u161a\0\u1648\0\u1676\0\u16a4\0\56\0\u16d2"+
    "\0\u1700\0\u172e\0\56\0\u175c\0\u178a\0\u17b8\0\u17e6\0\56"+
    "\0\u1814\0\u1842\0\u1870\0\56\0\u189e\0\u18cc\0\u18fa\0\u1928"+
    "\0\u1956\0\u1984\0\u19b2\0\u19e0\0\u1a0e\0\u1a3c\0\56\0\u1a6a"+
    "\0\56\0\u1a98\0\u1ac6\0\u1af4\0\u1b22\0\u1b50\0\u1b7e\0\u1bac"+
    "\0\u0cf0\0\56\0\u1bda\0\u1c08\0\u1c36\0\u1c64\0\u1c92\0\u1cc0"+
    "\0\56\0\u1cee\0\u1d1c\0\56\0\56\0\u1d4a\0\u1d78\0\u1da6"+
    "\0\u1dd4\0\u1e02\0\u1e30\0\u1e5e\0\u1e8c\0\56\0\u1eba\0\u1ee8"+
    "\0\u1f16\0\u1f44\0\u1f72\0\u1fa0\0\u1fce\0\u1ffc\0\u202a\0\u2058"+
    "\0\u2086\0\u20b4\0\u20e2\0\u2110\0\56\0\56\0\u213e\0\56"+
    "\0\u216c\0\u219a\0\u21c8\0\u21f6\0\56\0\56\0\u2224\0\56"+
    "\0\56\0\u2252\0\u2280\0\u22ae\0\u22dc\0\56\0\u230a\0\u2338"+
    "\0\56\0\u2366\0\u2394\0\u23c2\0\u23f0\0\u241e\0\u244c\0\u247a"+
    "\0\u24a8\0\u24d6\0\u2504\0\56\0\u2532\0\56\0\u2560\0\u258e"+
    "\0\56\0\u25bc\0\u25ea\0\u2618\0\u2646\0\u2674\0\u26a2\0\56"+
    "\0\u26d0\0\56\0\u26fe\0\u272c\0\56\0\u275a\0\u2788\0\56"+
    "\0\u27b6\0\u27e4\0\u2812\0\u2840\0\u286e\0\u289c\0\u28ca\0\u28f8"+
    "\0\u2926\0\u2954\0\u2982\0\u29b0\0\u29de\0\u2a0c\0\u2a3a\0\u2a68"+
    "\0\u2a96\0\56\0\56\0\u2ac4\0\u2af2\0\u2b20\0\u2b4e\0\56"+
    "\0\u2b7c\0\56\0\56\0\u2baa\0\u2bd8\0\u2c06\0\u2c34\0\u2c62"+
    "\0\56\0\u2c90\0\u2cbe\0\u2cec\0\u2d1a\0\u2d48\0\u2d76\0\56"+
    "\0\u2da4\0\u2dd2\0\u2e00\0\u2e2e\0\u2e5c\0\56\0\u2e8a\0\u2eb8"+
    "\0\u2ee6\0\u2f14\0\u2f42\0\u2f70\0\56\0\u2f9e\0\u2fcc\0\u2ffa"+
    "\0\56\0\u3028\0\u3056\0\u3084\0\56\0\u30b2\0\56\0\u30e0"+
    "\0\u310e\0\u313c\0\56\0\u316a\0\56\0\56\0\56\0\u3198"+
    "\0\56\0\u31c6\0\56\0\u31f4\0\u3222\0\u3250\0\u327e\0\56"+
    "\0\56\0\u32ac\0\u32da\0\u3308\0\u3336\0\u3364\0\u3392\0\56"+
    "\0\u33c0\0\u33ee\0\56\0\56\0\u341c\0\u344a\0\u3478\0\u34a6"+
    "\0\56\0\u34d4\0\u3502\0\u3530\0\u355e\0\u358c\0\u35ba\0\u35e8"+
    "\0\u3616\0\u3644\0\u3672\0\u36a0\0\u36ce\0\u36fc\0\56\0\u372a"+
    "\0\u3758\0\u3786\0\u37b4\0\u37e2\0\u3810\0\56\0\u383e\0\u386c"+
    "\0\u389a\0\56\0\56\0\u38c8\0\u38f6\0\56\0\u3924\0\u3952"+
    "\0\u3980\0\56\0\u39ae\0\56\0\u39dc\0\u3a0a\0\u3a38\0\u3a66"+
    "\0\56\0\56\0\56\0\u3a94\0\u3ac2\0\u3af0\0\u3b1e\0\u3b4c"+
    "\0\u3b7a\0\u3ba8\0\56\0\u3bd6\0\u3c04\0\u3c32\0\u3c60\0\u3c8e"+
    "\0\56\0\u3cbc\0\56\0\u3cea\0\u3d18\0\u3d46\0\56\0\56";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[416];
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
    "\1\2\1\3\1\4\1\3\1\5\1\6\1\7\1\10"+
    "\1\2\1\6\3\2\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\2\1\31\1\32\1\2\1\33"+
    "\4\2\1\34\2\2\1\35\2\2\1\36\1\3\57\0"+
    "\3\3\51\0\1\3\1\0\2\3\1\37\51\0\1\3"+
    "\5\0\1\40\3\0\1\41\103\0\1\42\23\0\1\43"+
    "\22\0\1\44\55\0\1\45\32\0\1\40\2\0\1\46"+
    "\11\0\1\47\5\0\1\50\32\0\1\51\72\0\1\52"+
    "\40\0\1\53\2\0\1\54\11\0\1\55\52\0\1\56"+
    "\2\0\1\57\41\0\1\60\25\0\1\61\16\0\1\62"+
    "\7\0\1\63\2\0\1\64\11\0\1\65\5\0\1\66"+
    "\33\0\1\67\16\0\1\70\5\0\1\71\47\0\1\70"+
    "\60\0\1\72\33\0\1\73\77\0\1\74\32\0\1\75"+
    "\14\0\1\76\40\0\1\77\2\0\1\100\13\0\1\101"+
    "\3\0\1\102\1\0\1\103\30\0\1\104\2\0\1\105"+
    "\11\0\1\106\1\0\1\107\16\0\1\106\17\0\1\110"+
    "\2\0\1\111\11\0\1\112\1\0\1\113\36\0\1\114"+
    "\2\0\1\115\11\0\1\116\1\0\1\117\20\0\1\120"+
    "\20\0\1\121\71\0\1\122\36\0\1\123\11\0\1\124"+
    "\4\0\1\125\105\0\1\126\7\0\1\127\61\0\1\130"+
    "\53\0\1\131\64\0\1\132\60\0\1\133\102\0\1\134"+
    "\30\0\1\135\43\0\1\136\6\0\1\137\53\0\1\140"+
    "\57\0\1\141\43\0\1\142\65\0\1\143\5\0\1\144"+
    "\65\0\1\145\41\0\1\146\43\0\1\147\14\0\1\150"+
    "\15\0\1\151\23\0\1\152\10\0\1\153\53\0\1\154"+
    "\76\0\1\155\36\0\1\156\55\0\1\157\44\0\1\160"+
    "\6\0\1\161\62\0\1\162\20\0\1\162\45\0\1\163"+
    "\44\0\1\164\65\0\1\165\33\0\1\166\52\0\1\167"+
    "\60\0\1\170\70\0\1\171\7\0\1\172\56\0\1\173"+
    "\40\0\1\174\1\0\1\175\1\0\1\176\25\0\1\177"+
    "\12\0\1\200\66\0\1\201\13\0\1\202\27\0\1\203"+
    "\14\0\1\204\10\0\1\205\52\0\1\206\42\0\1\207"+
    "\55\0\1\210\5\0\1\211\54\0\1\212\50\0\1\213"+
    "\65\0\1\214\72\0\1\215\51\0\1\216\1\217\35\0"+
    "\1\220\61\0\1\221\54\0\1\222\10\0\1\223\37\0"+
    "\1\224\15\0\1\225\55\0\1\223\37\0\1\210\63\0"+
    "\1\226\52\0\1\227\65\0\1\230\33\0\1\231\47\0"+
    "\55\126\10\0\1\232\61\0\1\233\66\0\1\234\25\0"+
    "\1\234\10\0\1\235\70\0\1\236\61\0\1\237\52\0"+
    "\1\240\51\0\1\241\60\0\1\242\67\0\1\243\43\0"+
    "\1\244\71\0\1\245\45\0\1\246\67\0\1\247\40\0"+
    "\1\250\56\0\1\251\50\0\1\252\15\0\1\253\44\0"+
    "\1\114\55\0\1\254\43\0\1\255\67\0\1\256\52\0"+
    "\1\257\57\0\1\260\41\0\1\55\100\0\1\261\13\0"+
    "\1\261\16\0\1\262\65\0\1\263\62\0\1\264\57\0"+
    "\1\265\37\0\1\266\13\0\1\267\55\0\1\267\101\0"+
    "\1\270\31\0\1\271\40\0\1\272\71\0\1\273\60\0"+
    "\1\274\36\0\1\275\72\0\1\276\20\0\1\276\45\0"+
    "\1\277\46\0\1\300\36\0\1\301\71\0\1\302\42\0"+
    "\1\303\101\0\1\304\42\0\1\305\57\0\1\306\60\0"+
    "\1\307\54\0\1\310\35\0\1\311\57\0\1\312\65\0"+
    "\1\313\50\0\1\314\67\0\1\315\70\0\1\316\41\0"+
    "\1\317\56\0\1\320\101\0\1\321\33\0\1\322\52\0"+
    "\1\323\73\0\1\324\26\0\1\325\61\0\1\325\56\0"+
    "\1\326\46\0\1\327\71\0\1\330\55\0\1\331\43\0"+
    "\1\332\55\0\1\333\55\0\1\334\55\0\1\335\62\0"+
    "\1\336\50\0\1\337\71\0\1\340\53\0\1\341\72\0"+
    "\1\342\43\0\1\343\72\0\1\344\35\0\1\345\43\0"+
    "\1\346\34\0\1\346\13\0\1\347\73\0\1\350\67\0"+
    "\1\351\41\0\1\352\66\0\1\353\44\0\1\354\75\0"+
    "\1\355\23\0\1\356\67\0\1\357\55\0\1\360\62\0"+
    "\1\361\37\0\1\362\52\0\1\363\71\0\1\364\57\0"+
    "\1\365\41\0\1\366\67\0\1\367\62\0\1\370\37\0"+
    "\1\371\71\0\1\372\72\0\1\373\21\0\1\374\62\0"+
    "\1\375\104\0\1\376\23\0\1\212\55\0\1\377\67\0"+
    "\1\u0100\43\0\1\u0101\55\0\1\u0102\57\0\1\u0103\102\0"+
    "\1\u0104\24\0\1\u0105\60\0\1\325\104\0\1\u0106\37\0"+
    "\1\u0107\55\0\1\u0108\62\0\1\u0109\36\0\1\u010a\55\0"+
    "\1\u010b\65\0\1\u010c\46\0\1\u010d\70\0\1\u010e\6\0"+
    "\1\u010f\2\0\1\u0110\3\0\1\u0111\35\0\1\344\60\0"+
    "\1\u0112\57\0\1\u0113\50\0\1\u0114\62\0\1\u0115\64\0"+
    "\1\u0116\46\0\1\u0117\36\0\1\u0118\103\0\1\u0119\46\0"+
    "\1\u011a\36\0\1\u011b\67\0\1\u011c\62\0\1\u011d\36\0"+
    "\1\u011e\72\0\1\u011f\66\0\1\u0120\46\0\1\u0121\66\0"+
    "\1\u0122\23\0\1\u0123\60\0\1\u0124\54\0\1\u0125\104\0"+
    "\1\u0126\60\0\1\u0127\23\0\1\271\74\0\1\u0128\41\0"+
    "\1\u0129\64\0\1\u012a\106\0\1\u012b\30\0\1\u012c\47\0"+
    "\1\u012d\50\0\1\u012e\64\0\1\u012f\44\0\1\u0130\77\0"+
    "\1\u0131\51\0\1\u0132\100\0\1\u0133\11\0\1\u0134\74\0"+
    "\1\u0135\41\0\1\u0136\73\0\1\u0137\36\0\1\u0138\65\0"+
    "\1\u0139\77\0\1\u013a\21\0\1\u013b\76\0\1\u013c\55\0"+
    "\1\u013d\53\0\1\u013e\54\0\1\u013f\73\0\1\u0140\40\0"+
    "\1\u0141\55\0\1\u0142\40\0\1\u0143\72\0\1\u0144\43\0"+
    "\1\u0145\67\0\1\u0146\57\0\1\u0147\53\0\1\u0148\57\0"+
    "\1\u0149\36\0\1\u014a\65\0\1\u014b\70\0\1\u014c\64\0"+
    "\1\u014d\26\0\1\u014e\101\0\1\u014f\36\0\1\u0150\45\0"+
    "\1\u0151\73\0\1\u0152\3\0\1\u0153\4\0\1\u0154\14\0"+
    "\1\u0155\40\0\1\u0156\27\0\1\u0157\54\0\1\u0158\71\0"+
    "\1\u0159\37\0\1\u015a\67\0\1\u015b\55\0\1\u015c\61\0"+
    "\1\u015d\56\0\1\u015e\55\0\1\u015f\54\0\1\u0160\41\0"+
    "\1\u0161\74\0\1\u0162\61\0\1\u0163\35\0\1\u0164\64\0"+
    "\1\u0165\43\0\1\u0166\53\0\1\u0167\57\0\1\u0168\67\0"+
    "\1\u0169\13\0\1\u016a\2\0\1\u016b\36\0\1\u016c\53\0"+
    "\1\u016d\43\0\1\u016e\76\0\1\u016f\50\0\1\u0170\60\0"+
    "\1\u0171\56\0\1\u0172\54\0\1\u0173\72\0\1\u0174\51\0"+
    "\1\u0175\37\0\1\u0176\62\0\1\u0177\40\0\1\u0178\74\0"+
    "\1\u0179\55\0\1\u017a\36\0\1\u017b\70\0\1\u017c\12\0"+
    "\1\u017d\27\0\1\u017e\65\0\1\u017f\64\0\1\u0180\25\0"+
    "\1\u0180\20\0\1\u0181\45\0\1\u0182\55\0\1\u0183\65\0"+
    "\1\u0184\63\0\1\u0185\66\0\1\u0186\26\0\1\u0187\55\0"+
    "\1\u0188\74\0\1\u0189\37\0\1\u018a\54\0\1\u018b\67\0"+
    "\1\u018c\43\0\1\u018d\104\0\1\u018e\31\0\1\u018f\100\0"+
    "\1\u0190\27\0\1\u0191\67\0\1\u0192\62\0\1\u0193\37\0"+
    "\1\u0194\54\0\1\u0195\73\0\1\u0196\56\0\1\u0197\41\0"+
    "\1\u0198\71\0\1\u0199\53\0\1\u019a\41\0\1\u019b\103\0"+
    "\1\u019c\55\0\1\u019d\55\0\1\u019e\45\0\1\u019f\36\0"+
    "\1\u01a0\50\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[15732];
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
    "\1\0\1\11\16\1\1\11\16\1\21\0\1\11\11\0"+
    "\1\1\10\0\1\1\11\0\1\11\7\0\1\1\17\0"+
    "\1\11\15\0\1\11\2\0\1\11\17\0\1\11\3\0"+
    "\1\11\4\0\1\11\3\0\1\11\12\0\1\11\1\0"+
    "\1\11\7\0\1\1\1\11\6\0\1\11\2\0\2\11"+
    "\10\0\1\11\16\0\2\11\1\0\1\11\4\0\2\11"+
    "\1\0\2\11\4\0\1\11\2\0\1\11\12\0\1\11"+
    "\1\0\1\11\2\0\1\11\6\0\1\11\1\0\1\11"+
    "\2\0\1\11\2\0\1\11\21\0\2\11\4\0\1\11"+
    "\1\0\2\11\5\0\1\11\6\0\1\11\5\0\1\11"+
    "\6\0\1\11\3\0\1\11\3\0\1\11\1\0\1\11"+
    "\3\0\1\11\1\0\3\11\1\0\1\11\1\0\1\11"+
    "\4\0\2\11\6\0\1\11\2\0\2\11\4\0\1\11"+
    "\15\0\1\11\6\0\1\11\3\0\2\11\2\0\1\11"+
    "\3\0\1\11\1\0\1\11\4\0\3\11\7\0\1\11"+
    "\5\0\1\11\1\0\1\11\3\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[416];
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
    private Symbol symbol(int type, Object value){
        return new Symbol(type,yyline,yycolumn,value);
    }
    private Symbol symbol(int type){
        return new Symbol(type,yyline,yycolumn);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerCup(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  LexerCup(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
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
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
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

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
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
        case 12: 
          { return new Symbol(sym.LAS,yychar,yyline,yytext());
          }
        case 78: break;
        case 71: 
          { return new Symbol(sym.PIE_LIMON,yychar,yyline,yytext());
          }
        case 79: break;
        case 69: 
          { return new Symbol(sym.SUSHI_RES,yychar,yyline,yytext());
          }
        case 80: break;
        case 5: 
          { return new Symbol(sym.EL,yychar,yyline,yytext());
          }
        case 81: break;
        case 55: 
          { return new Symbol(sym.MESAA,yychar,yyline,yytext());
          }
        case 82: break;
        case 47: 
          { return new Symbol(sym.CATORCE,yychar,yyline,yytext());
          }
        case 83: break;
        case 19: 
          { return new Symbol(sym.TRES,yychar,yyline,yytext());
          }
        case 84: break;
        case 62: 
          { return new Symbol(sym.COCA_COLA,yychar,yyline,yytext());
          }
        case 85: break;
        case 8: 
          { return new Symbol(sym.DE,yychar,yyline,yytext());
          }
        case 86: break;
        case 75: 
          { return new Symbol(sym.SUSHI_CAMARON,yychar,yyline,yytext());
          }
        case 87: break;
        case 59: 
          { return new Symbol(sym.NARANJADA,yychar,yyline,yytext());
          }
        case 88: break;
        case 39: 
          { return new Symbol(sym.QUINCE,yychar,yyline,yytext());
          }
        case 89: break;
        case 27: 
          { return new Symbol(sym.ADIOS,yychar,yyline,yytext());
          }
        case 90: break;
        case 64: 
          { return new Symbol(sym.SERVILLETAS,yychar,yyline,yytext());
          }
        case 91: break;
        case 20: 
          { return new Symbol(sym.MENU,yychar,yyline,yytext());
          }
        case 92: break;
        case 43: 
          { return new Symbol(sym.CUENTA,yychar,yyline,yytext());
          }
        case 93: break;
        case 25: 
          { return new Symbol(sym.DOCE,yychar,yyline,yytext());
          }
        case 94: break;
        case 31: 
          { return new Symbol(sym.TRECE,yychar,yyline,yytext());
          }
        case 95: break;
        case 7: 
          { return new Symbol(sym.LA,yychar,yyline,yytext());
          }
        case 96: break;
        case 2: 
          { /*Ignore*/
          }
        case 97: break;
        case 13: 
          { return new Symbol(sym.LOS,yychar,yyline,yytext());
          }
        case 98: break;
        case 52: 
          { return new Symbol(sym.TERIYAKI,yychar,yyline,yytext());
          }
        case 99: break;
        case 3: 
          { return new Symbol(sym.Y,yychar,yyline,yytext());
          }
        case 100: break;
        case 61: 
          { return new Symbol(sym.MESAC,yychar,yyline,yytext());
          }
        case 101: break;
        case 58: 
          { return new Symbol(sym.LIMONADA,yychar,yyline,yytext());
          }
        case 102: break;
        case 44: 
          { return new Symbol(sym.PEDIDO,yychar,yyline,yytext());
          }
        case 103: break;
        case 60: 
          { return new Symbol(sym.TENEDORES,yychar,yyline,yytext());
          }
        case 104: break;
        case 33: 
          { return new Symbol(sym.CARTA,yychar,yyline,yytext());
          }
        case 105: break;
        case 53: 
          { return new Symbol(sym.MOSTRAR,yychar,yyline,yytext());
          }
        case 106: break;
        case 50: 
          { return new Symbol(sym.FONDANT,yychar,yyline,yytext());
          }
        case 107: break;
        case 14: 
          { return new Symbol(sym.POR,yychar,yyline,yytext());
          }
        case 108: break;
        case 24: 
          { return new Symbol(sym.DIEZ,yychar,yyline,yytext());
          }
        case 109: break;
        case 72: 
          { return new Symbol(sym.PIE_FRESA,yychar,yyline,yytext());
          }
        case 110: break;
        case 40: 
          { return new Symbol(sym.QUIERO,yychar,yyline,yytext());
          }
        case 111: break;
        case 49: 
          { return new Symbol(sym.BOMBAZO,yychar,yyline,yytext());
          }
        case 112: break;
        case 57: 
          { return new Symbol(sym.CUCHARAS,yychar,yyline,yytext());
          }
        case 113: break;
        case 51: 
          { return new Symbol(sym.VICTORIA,yychar,yyline,yytext());
          }
        case 114: break;
        case 29: 
          { return new Symbol(sym.SIETE,yychar,yyline,yytext());
          }
        case 115: break;
        case 32: 
          { return new Symbol(sym.HACER,yychar,yyline,yytext());
          }
        case 116: break;
        case 73: 
          { return new Symbol(sym.SUSHI_POLLO,yychar,yyline,yytext());
          }
        case 117: break;
        case 34: 
          { return new Symbol(sym.CINCO,yychar,yyline,yytext());
          }
        case 118: break;
        case 17: 
          { return new Symbol(sym.SEIS,yychar,yyline,yytext());
          }
        case 119: break;
        case 74: 
          { return new Symbol(sym.HELADO_CACAO,yychar,yyline,yytext());
          }
        case 120: break;
        case 45: 
          { return new Symbol(sym.VAMPIRO,yychar,yyline,yytext());
          }
        case 121: break;
        case 1: 
          { return new Symbol (sym.ERROR,yychar,yyline,yytext());
          }
        case 122: break;
        case 28: 
          { return new Symbol(sym.NUEVE,yychar,yyline,yytext());
          }
        case 123: break;
        case 15: 
          { return new Symbol(sym.DOS,yychar,yyline,yytext());
          }
        case 124: break;
        case 48: 
          { return new Symbol(sym.CHURROS,yychar,yyline,yytext());
          }
        case 125: break;
        case 41: 
          { return new Symbol(sym.CORONA,yychar,yyline,yytext());
          }
        case 126: break;
        case 36: 
          { return new Symbol(sym.LEER,yychar,yyline,yytext());
          }
        case 127: break;
        case 56: 
          { return new Symbol(sym.MESAB,yychar,yyline,yytext());
          }
        case 128: break;
        case 16: 
          { return new Symbol(sym.JUGO,yychar,yyline,yytext());
          }
        case 129: break;
        case 38: 
          { return new Symbol(sym.FAVOR,yychar,yyline,yytext());
          }
        case 130: break;
        case 76: 
          { return new Symbol(sym.FRUTA_CARAMELO,yychar,yyline,yytext());
          }
        case 131: break;
        case 9: 
          { return new Symbol(sym.VER,yychar,yyline,yytext());
          }
        case 132: break;
        case 18: 
          { return new Symbol(sym.TRAER,yychar,yyline,yytext());
          }
        case 133: break;
        case 6: 
          { return new Symbol(sym.CANT_UN,yychar,yyline,yytext());
          }
        case 134: break;
        case 66: 
          { return new Symbol(sym.HAMBURGUESA_ARROZ,yychar,yyline,yytext());
          }
        case 135: break;
        case 4: 
          { return new Symbol(sym.Coma,yychar,yyline,yytext());
          }
        case 136: break;
        case 68: 
          { return new Symbol(sym.PIÑA_COLADA,yychar,yyline,yytext());
          }
        case 137: break;
        case 37: 
          { return new Symbol(sym.PEPSI,yychar,yyline,yytext());
          }
        case 138: break;
        case 26: 
          { return new Symbol(sym.SANJI,yychar,yyline,yytext());
          }
        case 139: break;
        case 23: 
          { return new Symbol(sym.CAFE,yychar,yyline,yytext());
          }
        case 140: break;
        case 11: 
          { return new Symbol(sym.CANT_UNA,yychar,yyline,yytext());
          }
        case 141: break;
        case 35: 
          { return new Symbol(sym.LISTO,yychar,yyline,yytext());
          }
        case 142: break;
        case 22: 
          { return new Symbol(sym.OCHO,yychar,yyline,yytext());
          }
        case 143: break;
        case 63: 
          { return new Symbol(sym.CAMARONITO,yychar,yyline,yytext());
          }
        case 144: break;
        case 54: 
          { return new Symbol(sym.EXPRESSO,yychar,yyline,yytext());
          }
        case 145: break;
        case 21: 
          { return new Symbol(sym.ONCE,yychar,yyline,yytext());
          }
        case 146: break;
        case 10: 
          { return new Symbol(sym.OYE,yychar,yyline,yytext());
          }
        case 147: break;
        case 42: 
          { return new Symbol(sym.CUATRO,yychar,yyline,yytext());
          }
        case 148: break;
        case 77: 
          { return new Symbol(sym.HELADO_VAINILLA,yychar,yyline,yytext());
          }
        case 149: break;
        case 46: 
          { return new Symbol(sym.MARTINI,yychar,yyline,yytext());
          }
        case 150: break;
        case 65: 
          { return new Symbol(sym.MESAD,yychar,yyline,yytext());
          }
        case 151: break;
        case 67: 
          { return new Symbol(sym.PIE_MORA,yychar,yyline,yytext());
          }
        case 152: break;
        case 30: 
          { return new Symbol(sym.VASOS,yychar,yyline,yytext());
          }
        case 153: break;
        case 70: 
          { return new Symbol(sym.PIE_QUESO,yychar,yyline,yytext());
          }
        case 154: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
