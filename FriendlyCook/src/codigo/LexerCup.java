/* The following code was generated by JFlex 1.4.3 on 11/12/20 06:32 PM */


package codigo;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 11/12/20 06:32 PM from the specification file
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
     0,  0,  0,  0,  0,  0,  0,  0,  0,  2, 39,  0,  0,  2,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     4,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  3,  0,  0, 38, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0, 10,  1,  1,  1,  1,  1,  1,  1, 13, 12,  1,  1,  1, 11, 21, 
     1, 24,  1,  5,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  1, 
     1,  6, 32, 26, 30, 17, 35, 33, 25,  9,  8, 34, 27, 18,  7, 19, 
    29, 22, 16, 14, 15, 23, 31,  1, 36, 20, 28,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1, 37,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\1\2\3\11\1\1\4\14\1\1\2"+
    "\1\5\13\1\1\6\6\1\1\7\10\1\1\10\6\1"+
    "\1\11\10\1\1\3\16\1\1\12\2\1\1\13\14\1"+
    "\1\14\1\1\1\15\4\1\1\16\1\1\1\17\12\1"+
    "\1\20\1\1\1\21\12\1\1\22\5\1\1\0\12\1"+
    "\1\23\11\1\1\24\3\1\1\0\2\1\2\0\1\25"+
    "\5\1\1\26\3\1\1\0\1\21\4\1\1\27\3\1"+
    "\1\30\1\0\2\1\2\0\1\31\1\0\3\1\1\0"+
    "\2\1\1\0\2\1\1\32\1\1\1\0\1\1\1\0"+
    "\1\33\1\1\3\0\1\34\1\1\1\35\1\0\1\36"+
    "\1\1\1\0\1\37\1\40\1\1\1\0\1\1\1\0"+
    "\1\41\6\0\1\42\1\0\1\43\1\0\1\1\1\0"+
    "\1\1\1\44\12\0\1\1\1\0\1\45\12\0\1\46"+
    "\2\0\1\47\3\0\1\50\2\0\1\51\4\0\1\52"+
    "\1\53\1\54\11\0\1\55\2\0\1\56\2\0\1\57"+
    "\2\0\1\60\3\0\1\61\1\62";

  private static int [] zzUnpackAction() {
    int [] result = new int[312];
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
    "\0\0\0\50\0\120\0\170\0\240\0\310\0\360\0\u0118"+
    "\0\u0140\0\u0168\0\u0190\0\u01b8\0\u01e0\0\u0208\0\120\0\u0230"+
    "\0\u0258\0\u0280\0\u02a8\0\u02d0\0\u02f8\0\u0320\0\u0348\0\u0370"+
    "\0\u0398\0\u03c0\0\u03e8\0\u0410\0\170\0\u0438\0\u0460\0\u0488"+
    "\0\u04b0\0\u04d8\0\u0500\0\u0528\0\u0550\0\u0578\0\u05a0\0\u05c8"+
    "\0\120\0\u05f0\0\u0618\0\u0640\0\u0668\0\u0690\0\u06b8\0\u06e0"+
    "\0\u0708\0\u0730\0\u0758\0\u0780\0\u07a8\0\u07d0\0\u07f8\0\u0820"+
    "\0\u0848\0\u0870\0\u0898\0\u08c0\0\u08e8\0\u0910\0\u0938\0\120"+
    "\0\u0960\0\u0988\0\u09b0\0\u09d8\0\u0a00\0\u0a28\0\u0a50\0\u0a78"+
    "\0\u0aa0\0\u0ac8\0\u0af0\0\u0b18\0\u0b40\0\u0b68\0\u0b90\0\u0bb8"+
    "\0\u0be0\0\u0c08\0\u0c30\0\u0c58\0\u0c80\0\u0ca8\0\u0cd0\0\120"+
    "\0\u0cf8\0\u0d20\0\120\0\u0d48\0\u0d70\0\u0d98\0\u0dc0\0\u0de8"+
    "\0\u0e10\0\u0e38\0\u0e60\0\u0e88\0\u0eb0\0\u0ed8\0\u0f00\0\120"+
    "\0\u0f28\0\120\0\u0f50\0\u0f78\0\u0fa0\0\u0fc8\0\120\0\u0ff0"+
    "\0\120\0\u1018\0\u1040\0\u1068\0\u1090\0\u10b8\0\u10e0\0\u1108"+
    "\0\u1130\0\u1158\0\u1180\0\120\0\u11a8\0\u11d0\0\u11f8\0\u1220"+
    "\0\u1248\0\u1270\0\u1298\0\u12c0\0\u12e8\0\u1310\0\u1338\0\u1360"+
    "\0\120\0\u1388\0\u13b0\0\u13d8\0\u1400\0\u1428\0\u1450\0\u1478"+
    "\0\u14a0\0\u14c8\0\u14f0\0\u1518\0\u1540\0\u1568\0\u1590\0\u15b8"+
    "\0\u15e0\0\120\0\u1608\0\u1630\0\u1658\0\u1680\0\u16a8\0\u16d0"+
    "\0\u16f8\0\u1720\0\u1748\0\120\0\u1770\0\u1798\0\u17c0\0\u17e8"+
    "\0\u1810\0\u1838\0\u1860\0\u1888\0\120\0\u18b0\0\u18d8\0\u1900"+
    "\0\u1928\0\u1950\0\120\0\u1978\0\u19a0\0\u19c8\0\u19f0\0\120"+
    "\0\u1a18\0\u1a40\0\u1a68\0\u1a90\0\120\0\u1ab8\0\u1ae0\0\u1b08"+
    "\0\120\0\u1b30\0\u1b58\0\u1b80\0\u1ba8\0\u1bd0\0\120\0\u1bf8"+
    "\0\u1c20\0\u1c48\0\u1c70\0\u1c98\0\u1cc0\0\u1ce8\0\u1d10\0\u1d38"+
    "\0\u1d60\0\120\0\u1d88\0\u1db0\0\u1dd8\0\u1e00\0\120\0\u1e28"+
    "\0\u1e50\0\u1e78\0\u1ea0\0\120\0\u1ec8\0\120\0\u1ef0\0\120"+
    "\0\u1f18\0\u1f40\0\120\0\120\0\u1f68\0\u1f90\0\u1fb8\0\u1fe0"+
    "\0\120\0\u2008\0\u2030\0\u2058\0\u2080\0\u20a8\0\u20d0\0\120"+
    "\0\u20f8\0\120\0\u2120\0\u2148\0\u2170\0\u2198\0\50\0\u21c0"+
    "\0\u21e8\0\u2210\0\u2238\0\u2260\0\u2288\0\u22b0\0\u22d8\0\u2300"+
    "\0\u2328\0\u2350\0\u2378\0\120\0\u23a0\0\u23c8\0\u23f0\0\u2418"+
    "\0\u2440\0\u2468\0\u2490\0\u24b8\0\u24e0\0\u2508\0\120\0\u2530"+
    "\0\u2558\0\50\0\u2580\0\u25a8\0\u25d0\0\50\0\u25f8\0\u2620"+
    "\0\50\0\u2648\0\u2670\0\u2698\0\u26c0\0\50\0\50\0\50"+
    "\0\u26e8\0\u2710\0\u2738\0\u2760\0\u2788\0\u27b0\0\u27d8\0\u2800"+
    "\0\u2828\0\50\0\u2850\0\u2878\0\50\0\u28a0\0\u28c8\0\50"+
    "\0\u28f0\0\u2918\0\50\0\u2940\0\u2968\0\u2990\0\50\0\50";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[312];
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
    "\1\2\1\3\1\4\1\5\1\4\1\6\1\3\1\7"+
    "\1\10\5\3\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\3\1\27\1\30\1\31\1\32\2\3\1\33\2\3"+
    "\1\34\1\4\51\0\1\3\3\0\41\3\4\0\3\4"+
    "\42\0\1\4\2\0\2\4\1\35\42\0\1\4\1\0"+
    "\1\3\3\0\1\3\1\36\3\3\1\37\33\3\3\0"+
    "\1\3\3\0\1\3\1\40\20\3\1\41\16\3\3\0"+
    "\1\3\3\0\22\3\1\42\16\3\3\0\1\3\3\0"+
    "\1\3\1\36\2\3\1\43\7\3\1\44\5\3\1\45"+
    "\16\3\3\0\1\3\3\0\13\3\1\46\1\47\24\3"+
    "\3\0\1\3\3\0\14\3\1\50\24\3\3\0\1\3"+
    "\3\0\26\3\1\51\10\3\1\52\1\3\3\0\1\3"+
    "\3\0\1\3\1\53\37\3\3\0\1\3\3\0\2\3"+
    "\1\54\14\3\1\55\5\3\1\56\13\3\3\0\1\3"+
    "\3\0\17\3\1\55\21\3\3\0\1\3\3\0\22\3"+
    "\1\57\16\3\3\0\1\3\3\0\2\3\1\60\36\3"+
    "\3\0\1\3\3\0\22\3\1\61\16\3\3\0\1\3"+
    "\3\0\1\3\1\62\12\3\1\63\24\3\3\0\1\3"+
    "\3\0\1\3\1\64\2\3\1\65\11\3\1\66\3\3"+
    "\1\67\1\3\1\70\14\3\3\0\1\3\3\0\1\3"+
    "\1\71\2\3\1\72\11\3\1\73\22\3\3\0\1\3"+
    "\3\0\4\3\1\74\7\3\1\75\1\3\1\76\22\3"+
    "\3\0\1\3\3\0\4\3\1\77\7\3\1\100\1\3"+
    "\1\101\3\3\1\102\16\3\3\0\1\3\3\0\1\3"+
    "\1\103\2\3\1\104\34\3\3\0\1\3\3\0\16\3"+
    "\1\105\22\3\3\0\1\3\3\0\1\3\1\106\11\3"+
    "\1\107\2\3\1\110\22\3\50\0\1\111\2\0\1\3"+
    "\3\0\2\3\1\112\36\3\3\0\1\3\3\0\6\3"+
    "\1\113\32\3\3\0\1\3\3\0\13\3\1\114\25\3"+
    "\3\0\1\3\3\0\14\3\1\115\24\3\3\0\1\3"+
    "\3\0\34\3\1\116\4\3\3\0\1\3\3\0\14\3"+
    "\1\117\24\3\3\0\1\3\3\0\4\3\1\120\34\3"+
    "\3\0\1\3\3\0\11\3\1\121\27\3\3\0\1\3"+
    "\3\0\1\3\1\122\12\3\1\101\24\3\3\0\1\3"+
    "\3\0\13\3\1\123\25\3\3\0\1\3\3\0\1\3"+
    "\1\124\37\3\3\0\1\3\3\0\30\3\1\125\10\3"+
    "\3\0\1\3\3\0\13\3\1\126\25\3\3\0\1\3"+
    "\3\0\25\3\1\127\13\3\3\0\1\3\3\0\14\3"+
    "\1\130\24\3\3\0\1\3\3\0\24\3\1\131\14\3"+
    "\3\0\1\3\3\0\4\3\1\132\34\3\3\0\1\3"+
    "\3\0\1\3\1\133\37\3\3\0\1\3\3\0\4\3"+
    "\1\134\34\3\3\0\1\3\3\0\15\3\1\135\7\3"+
    "\1\136\13\3\3\0\1\3\3\0\26\3\1\137\12\3"+
    "\3\0\1\3\3\0\12\3\1\140\2\3\1\141\20\3"+
    "\1\142\2\3\3\0\1\3\3\0\2\3\1\143\36\3"+
    "\3\0\1\3\3\0\13\3\1\144\11\3\1\145\13\3"+
    "\3\0\1\3\3\0\1\3\1\146\37\3\3\0\1\3"+
    "\3\0\22\3\1\147\16\3\3\0\1\3\3\0\11\3"+
    "\1\150\27\3\3\0\1\3\3\0\15\3\1\151\23\3"+
    "\3\0\1\3\3\0\11\3\1\152\27\3\3\0\1\3"+
    "\3\0\14\3\1\153\23\3\1\154\3\0\1\3\3\0"+
    "\30\3\1\155\1\156\7\3\3\0\1\3\3\0\13\3"+
    "\1\157\25\3\3\0\1\3\3\0\14\3\1\160\24\3"+
    "\3\0\1\3\3\0\11\3\1\161\13\3\1\127\13\3"+
    "\3\0\1\3\3\0\26\3\1\162\12\3\3\0\1\3"+
    "\3\0\15\3\1\163\23\3\3\0\1\3\3\0\25\3"+
    "\1\164\13\3\3\0\1\3\3\0\15\3\1\165\23\3"+
    "\3\0\1\3\3\0\32\3\1\166\6\3\3\0\1\3"+
    "\3\0\22\3\1\167\16\3\3\0\1\3\3\0\2\3"+
    "\1\170\36\3\2\0\47\111\2\0\1\3\3\0\3\3"+
    "\1\171\35\3\3\0\1\3\3\0\7\3\1\172\31\3"+
    "\3\0\1\3\3\0\1\3\1\173\37\3\3\0\1\3"+
    "\3\0\32\3\1\127\6\3\3\0\1\3\3\0\16\3"+
    "\1\174\22\3\3\0\1\3\3\0\12\3\1\127\26\3"+
    "\3\0\1\3\3\0\11\3\1\161\27\3\3\0\1\3"+
    "\3\0\24\3\1\175\14\3\3\0\1\3\3\0\14\3"+
    "\1\176\24\3\3\0\1\3\3\0\4\3\1\177\34\3"+
    "\3\0\1\3\3\0\26\3\1\200\12\3\3\0\1\3"+
    "\3\0\13\3\1\201\25\3\3\0\1\3\3\0\12\3"+
    "\1\202\26\3\3\0\1\3\3\0\14\3\1\161\24\3"+
    "\3\0\1\3\3\0\16\3\1\161\22\3\3\0\1\3"+
    "\3\0\2\3\1\54\11\3\1\203\24\3\3\0\1\3"+
    "\3\0\14\3\1\203\24\3\3\0\1\3\3\0\33\3"+
    "\1\204\5\3\3\0\1\3\3\0\14\3\1\205\24\3"+
    "\3\0\1\3\3\0\1\3\1\206\37\3\3\0\1\3"+
    "\3\0\16\3\1\207\22\3\3\0\1\3\3\0\1\3"+
    "\1\210\37\3\3\0\1\3\3\0\14\3\1\211\24\3"+
    "\3\0\1\3\3\0\25\3\1\131\13\3\3\0\1\3"+
    "\3\0\16\3\1\212\22\3\3\0\1\3\3\0\1\3"+
    "\1\213\37\3\3\0\1\3\3\0\12\3\1\214\26\3"+
    "\3\0\1\3\3\0\13\3\1\215\25\3\3\0\1\3"+
    "\3\0\16\3\1\216\22\3\3\0\1\3\2\0\1\217"+
    "\41\3\3\0\1\3\3\0\1\3\1\220\37\3\3\0"+
    "\1\3\3\0\11\3\1\221\27\3\3\0\1\3\3\0"+
    "\4\3\1\222\34\3\3\0\1\3\3\0\27\3\1\161"+
    "\11\3\3\0\1\3\3\0\25\3\1\223\13\3\3\0"+
    "\1\3\3\0\30\3\1\224\10\3\3\0\1\3\3\0"+
    "\12\3\1\225\26\3\3\0\1\3\3\0\33\3\1\226"+
    "\5\3\3\0\1\3\3\0\16\3\1\227\22\3\3\0"+
    "\1\3\3\0\12\3\1\230\26\3\3\0\1\3\3\0"+
    "\31\3\1\231\7\3\3\0\1\3\3\0\4\3\1\232"+
    "\34\3\3\0\1\3\3\0\10\3\1\232\30\3\3\0"+
    "\1\3\3\0\2\3\1\233\36\3\3\0\1\3\3\0"+
    "\4\3\1\234\34\3\3\0\1\3\3\0\15\3\1\235"+
    "\23\3\3\0\1\3\3\0\17\3\1\236\21\3\3\0"+
    "\1\3\3\0\4\3\1\237\34\3\3\0\1\3\3\0"+
    "\14\3\1\240\24\3\3\0\1\3\3\0\4\3\1\241"+
    "\34\3\3\0\1\3\3\0\13\3\1\242\25\3\3\0"+
    "\1\3\3\0\22\3\1\243\16\3\3\0\1\3\3\0"+
    "\13\3\1\244\25\3\3\0\1\3\3\0\31\3\1\245"+
    "\7\3\3\0\1\3\3\0\13\3\1\54\25\3\3\0"+
    "\1\3\3\0\13\3\1\246\25\3\3\0\1\3\3\0"+
    "\2\3\1\247\36\3\3\0\1\3\2\0\1\250\41\3"+
    "\3\0\1\3\3\0\13\3\1\131\25\3\3\0\1\3"+
    "\3\0\13\3\1\251\25\3\3\0\1\3\3\0\2\3"+
    "\1\252\36\3\40\0\1\253\12\0\1\3\2\0\1\254"+
    "\41\3\3\0\1\3\3\0\4\3\1\255\34\3\3\0"+
    "\1\3\3\0\31\3\1\256\7\3\3\0\1\3\3\0"+
    "\14\3\1\257\24\3\3\0\1\3\3\0\4\3\1\260"+
    "\34\3\3\0\1\3\3\0\16\3\1\261\22\3\3\0"+
    "\1\3\3\0\1\3\1\262\37\3\3\0\1\3\3\0"+
    "\13\3\1\263\25\3\3\0\1\3\3\0\1\3\1\264"+
    "\37\3\3\0\1\3\3\0\1\3\1\265\37\3\3\0"+
    "\1\3\3\0\3\3\1\266\35\3\3\0\1\3\2\0"+
    "\1\267\41\3\3\0\1\3\3\0\14\3\1\270\24\3"+
    "\3\0\1\3\3\0\1\3\1\271\37\3\3\0\1\3"+
    "\3\0\27\3\1\272\11\3\3\0\1\3\3\0\11\3"+
    "\1\273\27\3\3\0\1\3\3\0\2\3\1\274\36\3"+
    "\3\0\1\3\3\0\16\3\1\275\22\3\3\0\1\3"+
    "\3\0\13\3\1\276\25\3\3\0\1\3\3\0\16\3"+
    "\1\277\22\3\3\0\1\3\3\0\16\3\1\300\22\3"+
    "\3\0\1\3\3\0\1\3\1\301\37\3\34\0\1\302"+
    "\16\0\1\3\3\0\16\3\1\303\22\3\3\0\1\3"+
    "\3\0\1\3\1\304\37\3\23\0\1\305\60\0\1\306"+
    "\16\0\1\3\3\0\16\3\1\307\22\3\3\0\1\3"+
    "\2\0\1\310\41\3\3\0\1\3\3\0\13\3\1\311"+
    "\25\3\3\0\1\3\3\0\13\3\1\312\25\3\3\0"+
    "\1\3\3\0\27\3\1\313\11\3\3\0\1\3\2\0"+
    "\1\314\41\3\3\0\1\3\3\0\2\3\1\315\36\3"+
    "\3\0\1\3\3\0\1\3\1\316\37\3\40\0\1\317"+
    "\12\0\1\3\3\0\35\3\1\320\3\3\3\0\1\3"+
    "\3\0\1\3\1\205\37\3\3\0\1\3\3\0\11\3"+
    "\1\321\27\3\3\0\1\3\3\0\4\3\1\322\34\3"+
    "\3\0\1\3\3\0\34\3\1\323\4\3\3\0\1\3"+
    "\2\0\1\324\41\3\3\0\1\3\3\0\2\3\1\325"+
    "\36\3\25\0\1\326\25\0\1\3\3\0\11\3\1\327"+
    "\27\3\3\0\1\3\3\0\31\3\1\330\7\3\6\0"+
    "\1\331\66\0\1\332\62\0\1\333\12\0\1\3\3\0"+
    "\16\3\1\334\22\3\3\0\1\3\3\0\4\3\1\335"+
    "\34\3\3\0\1\3\3\0\16\3\1\336\22\3\23\0"+
    "\1\337\27\0\1\3\3\0\12\3\1\340\26\3\3\0"+
    "\1\3\3\0\31\3\1\341\7\3\23\0\1\342\27\0"+
    "\1\3\3\0\4\3\1\343\34\3\3\0\1\3\3\0"+
    "\16\3\1\344\22\3\3\0\1\3\3\0\22\3\1\345"+
    "\16\3\40\0\1\346\12\0\1\3\3\0\4\3\1\347"+
    "\34\3\35\0\1\350\15\0\1\3\3\0\1\3\1\351"+
    "\37\3\24\0\1\352\3\0\1\353\4\0\1\354\7\0"+
    "\1\355\37\0\1\356\35\0\1\357\27\0\1\3\3\0"+
    "\1\3\1\360\37\3\11\0\1\361\41\0\1\3\3\0"+
    "\1\3\1\362\37\3\6\0\1\363\44\0\1\3\3\0"+
    "\14\3\1\364\24\3\23\0\1\365\27\0\1\3\3\0"+
    "\12\3\1\366\26\3\10\0\1\367\64\0\1\370\53\0"+
    "\1\371\31\0\1\372\56\0\1\373\35\0\1\374\45\0"+
    "\1\375\47\0\1\376\63\0\1\377\11\0\1\u0100\2\0"+
    "\1\u0101\13\0\1\3\3\0\11\3\1\u0102\27\3\6\0"+
    "\1\u0103\44\0\1\3\3\0\16\3\1\u0104\22\3\22\0"+
    "\1\u0105\50\0\1\u0106\50\0\1\u0107\46\0\1\u0108\64\0"+
    "\1\u0109\44\0\1\u010a\46\0\1\u010b\36\0\1\u010c\34\0"+
    "\1\u010d\64\0\1\u010e\25\0\1\3\3\0\1\3\1\u010f"+
    "\37\3\34\0\1\u0110\4\0\1\u0111\16\0\1\u0112\57\0"+
    "\1\u0113\54\0\1\u0114\42\0\1\u0115\37\0\1\u0116\62\0"+
    "\1\u0117\34\0\1\u0118\57\0\1\u0119\53\0\1\u011a\60\0"+
    "\1\u011b\22\0\1\u011c\47\0\1\u011d\64\0\1\u011e\33\0"+
    "\1\u011f\46\0\1\u0120\73\0\1\u0121\35\0\1\u0122\35\0"+
    "\1\u0123\74\0\1\u0124\46\0\1\u0125\26\0\1\u0126\67\0"+
    "\1\u0127\24\0\1\u0128\61\0\1\u0129\52\0\1\u012a\32\0"+
    "\1\u012b\50\0\1\u012c\61\0\1\u012d\50\0\1\u012e\50\0"+
    "\1\u012f\47\0\1\u0130\35\0\1\u0131\57\0\1\u0132\35\0"+
    "\1\u0133\73\0\1\u0134\47\0\1\u0135\47\0\1\u0136\37\0"+
    "\1\u0137\32\0\1\u0138\41\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[10680];
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
    "\1\1\1\11\214\1\1\0\30\1\1\0\2\1\2\0"+
    "\12\1\1\0\12\1\1\0\2\1\2\0\1\1\1\0"+
    "\3\1\1\0\2\1\1\0\4\1\1\0\1\1\1\0"+
    "\2\1\3\0\3\1\1\0\2\1\1\0\3\1\1\0"+
    "\1\1\1\0\1\1\6\0\1\1\1\0\1\1\1\0"+
    "\1\1\1\0\1\1\1\11\12\0\1\1\1\0\1\1"+
    "\12\0\1\1\2\0\1\11\3\0\1\11\2\0\1\11"+
    "\4\0\3\11\11\0\1\11\2\0\1\11\2\0\1\11"+
    "\2\0\1\11\3\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[312];
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
        case 40: 
          { return new Symbol(sym.PIÑA_COLADA,yychar,yyline,yytext());
          }
        case 51: break;
        case 23: 
          { return new Symbol(sym.QUIERO,yychar,yyline,yytext());
          }
        case 52: break;
        case 38: 
          { return new Symbol(sym.HAMBURGUESA_ARROZ,yychar,yyline,yytext());
          }
        case 53: break;
        case 1: 
          { return new Symbol(sym.CADENA,yychar,yyline,yytext());
          }
        case 54: break;
        case 47: 
          { return new Symbol(sym.HELADO_CACAO,yychar,yyline,yytext());
          }
        case 55: break;
        case 36: 
          { return new Symbol(sym.COCA_COLA,yychar,yyline,yytext());
          }
        case 56: break;
        case 49: 
          { return new Symbol(sym.FRUTA_CARAMELO,yychar,yyline,yytext());
          }
        case 57: break;
        case 34: 
          { return new Symbol(sym.VICTORIA,yychar,yyline,yytext());
          }
        case 58: break;
        case 18: 
          { return new Symbol(sym.CAFE,yychar,yyline,yytext());
          }
        case 59: break;
        case 39: 
          { return new Symbol(sym.PIE_MORA,yychar,yyline,yytext());
          }
        case 60: break;
        case 8: 
          { return new Symbol(sym.LA,yychar,yyline,yytext());
          }
        case 61: break;
        case 30: 
          { return new Symbol(sym.FONDANT,yychar,yyline,yytext());
          }
        case 62: break;
        case 19: 
          { return new Symbol(sym.SANJI,yychar,yyline,yytext());
          }
        case 63: break;
        case 28: 
          { return new Symbol(sym.VAMPIRO,yychar,yyline,yytext());
          }
        case 64: break;
        case 26: 
          { return new Symbol(sym.MARTINI,yychar,yyline,yytext());
          }
        case 65: break;
        case 10: 
          { return new Symbol(sym.OYE,yychar,yyline,yytext());
          }
        case 66: break;
        case 42: 
          { return new Symbol(sym.PIE_QUESO,yychar,yyline,yytext());
          }
        case 67: break;
        case 13: 
          { return new Symbol(sym.LOS,yychar,yyline,yytext());
          }
        case 68: break;
        case 46: 
          { return new Symbol(sym.DULCE_LECHE,yychar,yyline,yytext());
          }
        case 69: break;
        case 16: 
          { return new Symbol(sym.JUGO,yychar,yyline,yytext());
          }
        case 70: break;
        case 9: 
          { return new Symbol(sym.DE,yychar,yyline,yytext());
          }
        case 71: break;
        case 35: 
          { return new Symbol(sym.NARANJADA,yychar,yyline,yytext());
          }
        case 72: break;
        case 5: 
          { return new Symbol(sym.Coma,yychar,yyline,yytext());
          }
        case 73: break;
        case 50: 
          { return new Symbol(sym.HELADO_VAINILLA,yychar,yyline,yytext());
          }
        case 74: break;
        case 12: 
          { return new Symbol(sym.LAS,yychar,yyline,yytext());
          }
        case 75: break;
        case 4: 
          { return new Symbol(sym.Y,yychar,yyline,yytext());
          }
        case 76: break;
        case 31: 
          { return new Symbol(sym.TERIYAKI,yychar,yyline,yytext());
          }
        case 77: break;
        case 45: 
          { return new Symbol(sym.SUSHI_POLLO,yychar,yyline,yytext());
          }
        case 78: break;
        case 20: 
          { return new Symbol(sym.HACER,yychar,yyline,yytext());
          }
        case 79: break;
        case 27: 
          { return new Symbol(sym.CHURROS,yychar,yyline,yytext());
          }
        case 80: break;
        case 6: 
          { return new Symbol(sym.EL,yychar,yyline,yytext());
          }
        case 81: break;
        case 41: 
          { return new Symbol(sym.SUSHI_RES,yychar,yyline,yytext());
          }
        case 82: break;
        case 44: 
          { return new Symbol(sym.PIE_FRESA,yychar,yyline,yytext());
          }
        case 83: break;
        case 32: 
          { return new Symbol(sym.EXPRESSO,yychar,yyline,yytext());
          }
        case 84: break;
        case 21: 
          { return new Symbol(sym.PEPSI,yychar,yyline,yytext());
          }
        case 85: break;
        case 33: 
          { return new Symbol(sym.LIMONADA,yychar,yyline,yytext());
          }
        case 86: break;
        case 15: 
          { return new Symbol(sym.CANT_PLURALES,yychar,yyline,yytext());
          }
        case 87: break;
        case 24: 
          { return new Symbol(sym.CORONA,yychar,yyline,yytext());
          }
        case 88: break;
        case 29: 
          { return new Symbol(sym.BOMBAZO,yychar,yyline,yytext());
          }
        case 89: break;
        case 22: 
          { return new Symbol(sym.FAVOR,yychar,yyline,yytext());
          }
        case 90: break;
        case 48: 
          { return new Symbol(sym.SUSHI_CAMARON,yychar,yyline,yytext());
          }
        case 91: break;
        case 3: 
          { /*Ignore*/
          }
        case 92: break;
        case 43: 
          { return new Symbol(sym.PIE_LIMON,yychar,yyline,yytext());
          }
        case 93: break;
        case 37: 
          { return new Symbol(sym.CAMARONITO,yychar,yyline,yytext());
          }
        case 94: break;
        case 11: 
          { return new Symbol(sym.CANT_UNA,yychar,yyline,yytext());
          }
        case 95: break;
        case 14: 
          { return new Symbol(sym.POR,yychar,yyline,yytext());
          }
        case 96: break;
        case 2: 
          { return new Symbol (sym.ERROR,yychar,yyline,yytext());
          }
        case 97: break;
        case 7: 
          { return new Symbol(sym.CANT_UN,yychar,yyline,yytext());
          }
        case 98: break;
        case 17: 
          { return new Symbol(sym.TRAER,yychar,yyline,yytext());
          }
        case 99: break;
        case 25: 
          { return new Symbol(sym.PEDIDO,yychar,yyline,yytext());
          }
        case 100: break;
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
