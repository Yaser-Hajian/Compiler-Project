package CodeGen;// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: Codes/src/CodeGen/Scanner.flex

// user code
// mesle package ha
// balaye code e scanner asli ezafe mishe.


import CodeGen.Lexical;

// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class My_Scanner implements Lexical {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
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
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\0\1\1\1\3\22\0\1\1"+
    "\1\4\1\5\2\0\1\6\1\7\1\10\2\6\1\11"+
    "\1\12\1\6\1\12\1\13\1\14\1\15\11\16\1\0"+
    "\1\6\1\4\1\17\1\4\2\0\1\20\3\21\1\22"+
    "\1\21\21\23\1\24\2\23\1\6\1\25\2\6\1\26"+
    "\1\0\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\23\1\40\1\41\1\23\1\42\1\43"+
    "\1\44\1\23\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\24\1\53\1\23\1\6\1\7\1\6\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
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
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\1\3\1\4\4\3\2\5\17\6"+
    "\1\7\2\10\1\11\1\1\1\0\1\12\1\13\2\0"+
    "\10\6\1\14\15\6\1\15\1\0\2\12\1\0\1\16"+
    "\1\17\10\6\1\14\13\6\1\14\13\6\1\14\10\6"+
    "\1\14\5\6\1\14\2\6\1\14\26\6";

  private static int [] zzUnpackAction() {
    int [] result = new int[140];
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
    "\0\0\0\54\0\130\0\130\0\204\0\260\0\130\0\130"+
    "\0\334\0\u0108\0\u0134\0\u0160\0\u018c\0\u01b8\0\u01e4\0\u0210"+
    "\0\u023c\0\u0268\0\u0294\0\u02c0\0\u02ec\0\u0318\0\u0344\0\u0370"+
    "\0\u039c\0\u03c8\0\u03f4\0\u0420\0\130\0\130\0\u044c\0\130"+
    "\0\u0478\0\u04a4\0\u04d0\0\u04fc\0\u0528\0\u0554\0\u0580\0\u05ac"+
    "\0\u05d8\0\u0604\0\u0630\0\u065c\0\u0688\0\u06b4\0\u0580\0\u06e0"+
    "\0\u070c\0\u0738\0\u0764\0\u0790\0\u07bc\0\u07e8\0\u0814\0\u0840"+
    "\0\u086c\0\u0898\0\u08c4\0\u08f0\0\130\0\u091c\0\130\0\u0948"+
    "\0\u0974\0\u0974\0\u0554\0\u09a0\0\u09cc\0\u09f8\0\u0a24\0\u0a50"+
    "\0\u0a7c\0\u0aa8\0\u0ad4\0\u09a0\0\u0b00\0\u0b2c\0\u0b58\0\u0b84"+
    "\0\u0bb0\0\u0bdc\0\u0c08\0\u0c34\0\u0c60\0\u0c8c\0\u0cb8\0\u0c8c"+
    "\0\u0ce4\0\u0d10\0\u0d3c\0\u0d68\0\u0d94\0\u0dc0\0\u0dec\0\u0e18"+
    "\0\u0e44\0\u0e70\0\u0e9c\0\u0e9c\0\u0ec8\0\u0ef4\0\u0f20\0\u0f4c"+
    "\0\u0f78\0\u0fa4\0\u0fd0\0\u0ffc\0\u0fd0\0\u1028\0\u1054\0\u1080"+
    "\0\u10ac\0\u10d8\0\u10d8\0\u1104\0\u1130\0\u1130\0\u115c\0\u1188"+
    "\0\u11b4\0\u11e0\0\u120c\0\u1238\0\u1264\0\u1290\0\u12bc\0\u12e8"+
    "\0\u1314\0\u1340\0\u136c\0\u1398\0\u13c4\0\u13f0\0\u141c\0\u1448"+
    "\0\u1474\0\u14a0\0\u14cc\0\130";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[140];
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
    "\1\3\2\4\1\5\1\6\1\7\1\10\1\11\1\3"+
    "\1\6\1\12\1\10\1\13\1\14\1\15\1\6\1\16"+
    "\4\17\2\3\1\17\1\20\1\21\1\17\1\22\1\23"+
    "\2\17\1\24\1\17\1\25\1\26\1\17\1\27\1\30"+
    "\1\31\1\32\1\17\1\33\1\34\1\17\1\35\2\36"+
    "\1\37\1\35\1\40\17\35\1\41\26\35\56\0\1\4"+
    "\70\0\1\10\43\0\1\10\2\0\1\10\50\0\1\10"+
    "\2\0\1\10\4\0\1\10\45\0\1\42\2\0\1\43"+
    "\2\0\1\10\47\0\1\44\1\0\2\15\3\0\1\45"+
    "\1\0\1\46\6\0\1\45\33\0\1\44\1\0\2\15"+
    "\3\0\1\45\10\0\1\45\35\0\2\47\1\0\5\47"+
    "\1\0\17\47\1\50\6\47\15\0\2\47\1\0\5\47"+
    "\1\0\26\47\15\0\2\47\1\0\5\47\1\0\15\47"+
    "\1\51\1\47\1\52\6\47\15\0\2\47\1\0\5\47"+
    "\1\0\13\47\1\53\1\47\1\54\10\47\15\0\2\47"+
    "\1\0\5\47\1\0\13\47\1\55\12\47\15\0\2\47"+
    "\1\0\5\47\1\0\1\47\1\56\7\47\1\57\3\47"+
    "\1\60\10\47\15\0\2\47\1\0\5\47\1\0\6\47"+
    "\1\57\5\47\1\61\11\47\15\0\2\47\1\0\5\47"+
    "\1\0\5\47\1\62\7\47\1\63\10\47\15\0\2\47"+
    "\1\0\5\47\1\0\5\47\1\64\20\47\15\0\2\47"+
    "\1\0\5\47\1\0\15\47\1\51\1\47\1\65\6\47"+
    "\15\0\2\47\1\0\5\47\1\0\5\47\1\66\7\47"+
    "\1\67\10\47\15\0\2\47\1\0\5\47\1\0\21\47"+
    "\1\70\4\47\15\0\2\47\1\0\5\47\1\0\10\47"+
    "\1\71\6\47\1\72\6\47\15\0\2\47\1\0\5\47"+
    "\1\0\15\47\1\73\10\47\15\0\2\47\1\0\5\47"+
    "\1\0\10\47\1\74\15\47\2\0\1\36\56\0\1\75"+
    "\2\0\1\75\14\0\1\75\14\0\1\75\2\0\1\75"+
    "\1\0\1\75\4\0\11\42\1\76\42\42\2\43\1\77"+
    "\1\100\50\43\15\0\2\44\3\0\1\45\10\0\1\45"+
    "\32\0\1\101\2\0\2\102\52\0\2\103\1\0\3\103"+
    "\4\0\6\103\34\0\2\104\1\0\5\104\1\0\26\104"+
    "\15\0\2\104\1\0\5\104\1\0\17\104\1\105\6\104"+
    "\15\0\2\104\1\0\5\104\1\0\15\104\1\106\10\104"+
    "\15\0\2\104\1\0\5\104\1\0\5\104\1\107\20\104"+
    "\15\0\2\104\1\0\5\104\1\0\1\104\1\110\24\104"+
    "\15\0\2\104\1\0\5\104\1\0\14\104\1\111\11\104"+
    "\15\0\2\104\1\0\5\104\1\0\20\104\1\112\5\104"+
    "\15\0\2\104\1\0\5\104\1\0\13\104\1\113\12\104"+
    "\15\0\2\104\1\0\5\104\1\0\17\104\1\114\6\104"+
    "\15\0\2\104\1\0\5\104\1\0\1\115\20\104\1\114"+
    "\4\104\15\0\2\104\1\0\5\104\1\0\14\104\1\114"+
    "\4\104\1\114\4\104\15\0\2\104\1\0\5\104\1\0"+
    "\15\104\1\116\10\104\15\0\2\104\1\0\5\104\1\0"+
    "\24\104\1\114\1\104\15\0\2\104\1\0\5\104\1\0"+
    "\11\104\1\117\14\104\15\0\2\104\1\0\5\104\1\0"+
    "\1\104\1\106\17\104\1\120\4\104\15\0\2\104\1\0"+
    "\5\104\1\0\6\104\1\114\17\104\15\0\2\104\1\0"+
    "\5\104\1\0\1\104\1\121\15\104\1\122\6\104\15\0"+
    "\2\104\1\0\5\104\1\0\5\104\1\123\20\104\15\0"+
    "\2\104\1\0\5\104\1\0\22\104\1\112\3\104\15\0"+
    "\2\104\1\0\5\104\1\0\11\104\1\124\14\104\15\0"+
    "\2\104\1\0\5\104\1\0\11\104\1\125\14\104\11\42"+
    "\1\76\2\42\1\77\37\42\2\0\1\77\66\0\2\102"+
    "\52\0\2\126\1\0\5\126\1\0\26\126\15\0\2\126"+
    "\1\0\5\126\1\0\1\126\1\127\24\126\15\0\2\126"+
    "\1\0\5\126\1\0\13\126\1\130\12\126\15\0\2\126"+
    "\1\0\5\126\1\0\1\126\1\131\24\126\15\0\2\126"+
    "\1\0\5\126\1\0\20\126\1\132\5\126\15\0\2\126"+
    "\1\0\5\126\1\0\21\126\1\133\4\126\15\0\2\126"+
    "\1\0\5\126\1\0\5\126\1\130\20\126\15\0\2\126"+
    "\1\0\5\126\1\0\20\126\1\134\5\126\15\0\2\126"+
    "\1\0\5\126\1\0\11\126\1\135\6\126\1\136\5\126"+
    "\15\0\2\126\1\0\5\126\1\0\16\126\1\130\7\126"+
    "\15\0\2\126\1\0\5\126\1\0\14\126\1\137\11\126"+
    "\15\0\2\126\1\0\5\126\1\0\22\126\1\140\3\126"+
    "\15\0\2\126\1\0\5\126\1\0\21\126\1\141\4\126"+
    "\15\0\2\126\1\0\5\126\1\0\11\126\1\142\14\126"+
    "\15\0\2\126\1\0\5\126\1\0\14\126\1\130\11\126"+
    "\15\0\2\126\1\0\5\126\1\0\4\126\1\130\21\126"+
    "\15\0\2\126\1\0\5\126\1\0\13\126\1\134\12\126"+
    "\15\0\2\143\1\0\5\143\1\0\26\143\15\0\2\143"+
    "\1\0\5\143\1\0\25\143\1\144\15\0\2\143\1\0"+
    "\5\143\1\0\12\143\1\144\13\143\15\0\2\143\1\0"+
    "\5\143\1\0\20\143\1\144\5\143\15\0\2\143\1\0"+
    "\5\143\1\0\11\143\1\145\14\143\15\0\2\143\1\0"+
    "\5\143\1\0\5\143\1\144\20\143\15\0\2\143\1\0"+
    "\5\143\1\0\14\143\1\146\11\143\15\0\2\143\1\0"+
    "\5\143\1\0\21\143\1\147\4\143\15\0\2\143\1\0"+
    "\5\143\1\0\21\143\1\144\4\143\15\0\2\143\1\0"+
    "\5\143\1\0\17\143\1\150\6\143\15\0\2\143\1\0"+
    "\5\143\1\0\11\143\1\151\14\143\15\0\2\143\1\0"+
    "\5\143\1\0\14\143\1\152\11\143\15\0\2\153\1\0"+
    "\5\153\1\0\26\153\15\0\2\153\1\0\5\153\1\0"+
    "\14\153\1\154\11\153\15\0\2\153\1\0\5\153\1\0"+
    "\21\153\1\155\4\153\15\0\2\153\1\0\5\153\1\0"+
    "\17\153\1\156\6\153\15\0\2\153\1\0\5\153\1\0"+
    "\14\153\1\155\11\153\15\0\2\153\1\0\5\153\1\0"+
    "\3\153\1\155\22\153\15\0\2\153\1\0\5\153\1\0"+
    "\7\153\1\155\16\153\15\0\2\157\1\0\5\157\1\0"+
    "\26\157\15\0\2\157\1\0\5\157\1\0\22\157\1\160"+
    "\3\157\15\0\2\157\1\0\5\157\1\0\11\157\1\161"+
    "\14\157\15\0\2\162\1\0\5\162\1\0\26\162\15\0"+
    "\2\162\1\0\5\162\1\0\5\162\1\163\20\162\15\0"+
    "\2\162\1\0\5\162\1\0\14\162\1\164\11\162\15\0"+
    "\2\165\1\0\5\165\1\0\26\165\15\0\2\165\1\0"+
    "\5\165\1\0\7\165\1\166\16\165\15\0\2\167\1\0"+
    "\5\167\1\0\26\167\15\0\2\170\1\0\5\170\1\0"+
    "\26\170\15\0\2\171\1\0\5\171\1\0\26\171\15\0"+
    "\2\172\1\0\5\172\1\0\26\172\15\0\2\173\1\0"+
    "\5\173\1\0\26\173\15\0\2\174\1\0\5\174\1\0"+
    "\26\174\15\0\2\175\1\0\5\175\1\0\26\175\15\0"+
    "\2\176\1\0\5\176\1\0\26\176\15\0\2\177\1\0"+
    "\5\177\1\0\26\177\15\0\2\200\1\0\5\200\1\0"+
    "\26\200\15\0\2\201\1\0\5\201\1\0\26\201\15\0"+
    "\2\202\1\0\5\202\1\0\26\202\15\0\2\203\1\0"+
    "\5\203\1\0\26\203\15\0\2\204\1\0\5\204\1\0"+
    "\26\204\15\0\2\205\1\0\5\205\1\0\26\205\15\0"+
    "\2\206\1\0\5\206\1\0\26\206\15\0\2\207\1\0"+
    "\5\207\1\0\26\207\15\0\2\210\1\0\5\210\1\0"+
    "\26\210\15\0\2\211\1\0\5\211\1\0\26\211\15\0"+
    "\2\212\1\0\5\212\1\0\26\212\15\0\2\213\1\0"+
    "\5\213\1\0\26\213\15\0\2\214\1\0\5\214\1\0"+
    "\26\214";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5368];
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


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\2\11\2\1\2\11\24\1\2\11\1\1\1\11"+
    "\1\1\1\0\2\1\2\0\26\1\1\11\1\0\1\11"+
    "\1\1\1\0\112\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[140];
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

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
     public class Token {
     public String type;
     public Object value;
     public int lineNumber;
     public Token(String type , Object value , int lineNumber){
         this.value=value;
         this.type=type;
         this.lineNumber=lineNumber;
     }
    }
    public String nextToken(){
      try{
          while (true){
              Token current = My_Next_Token();
                        if (current  == null){
                            return "$";
                        }
                        if (current.type.equals("Comment") || current.type.equals("WhiteSpace")){
                            continue;
                        }
                        if (current.type.equals("Reserved")){
                            return String.valueOf(current.value);
                        }
                        if (current.type.equals("Operators")) {
                            if (current.value.equals(",")){
                                return "comma";
                            }else {
                                return String.valueOf(current.value);
                            }
                        }
                        return current.type;
          }

      }catch (Exception e){
          e.printStackTrace();
          return null;
      }
    }
    //dakhele class e scanner ezafe misheh.
    // tarif e variable va function va class dar inja tarif mishavad.
    public int ICV;
    public double RCV;
    public Token current_Token;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public My_Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token My_Next_Token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
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

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { //    return "Error at line: "+yyline + "index: "+ yycolumn + "character = "+ yytext()  ;
     System.out.println("Error at line: "+yyline + "index: "+ yycolumn + "character = "+ yytext());
     current_Token = new Token("Undefined", yytext() , yyline) ;
     return current_Token;
            }
            // fall through
          case 16: break;
          case 2:
            { current_Token =  new Token("WhiteSpace",yytext(), yyline);
        return current_Token;
            }
            // fall through
          case 17: break;
          case 3:
            { current_Token=new Token("Operators",yytext(), yyline);
        return current_Token;
            }
            // fall through
          case 18: break;
          case 4:
            { yybegin(STRING);
        current_Token = new Token("StringLiteral",yytext(), yyline);
        return current_Token;
            }
            // fall through
          case 19: break;
          case 5:
            { ICV = Integer.parseInt(yytext());
        System.out.println("Number: "+ ICV + " ");
        current_Token = new Token("Integer",ICV, yyline);
        return current_Token;
            }
            // fall through
          case 20: break;
          case 6:
            { current_Token = new Token("identifiers",yytext() , yyline);
        return current_Token;
            }
            // fall through
          case 21: break;
          case 7:
            { current_Token = new Token("String",yytext(), yyline);
        return current_Token;
            }
            // fall through
          case 22: break;
          case 8:
            { current_Token = new Token("WhiteSpace",yytext(), yyline);
        return current_Token;
            }
            // fall through
          case 23: break;
          case 9:
            { yybegin(YYINITIAL);
        current_Token = new Token("StringLiteral",yytext(), yyline);
        return current_Token;
            }
            // fall through
          case 24: break;
          case 10:
            { current_Token=new Token("Comment",yytext() , yyline);
        return current_Token;
            }
            // fall through
          case 25: break;
          case 11:
            { RCV = Double.parseDouble(yytext());
        System.out.println("RealNumber: "+ RCV + " ");
        current_Token = new Token("Real", RCV, yyline);
        return current_Token;
            }
            // fall through
          case 26: break;
          case 12:
            { current_Token =   new Token("Reserved",yytext() , yyline);
        return current_Token;
            }
            // fall through
          case 27: break;
          case 13:
            { current_Token = new Token("Special Characters",yytext(), yyline);
        return current_Token;
            }
            // fall through
          case 28: break;
          case 14:
            { String sNumber = yytext();
        RCV = Double.parseDouble(sNumber);
        System.out.println("ScientificNotation: "+ sNumber + " " + "with decimal value of "+ RCV);
        current_Token=new Token("Real",sNumber, yyline);
        return current_Token;
            }
            // fall through
          case 29: break;
          case 15:
            { String hex_number = yytext();
        ICV = Integer.parseInt(hex_number.substring(2) , 16);
        System.out.println("HexNumber: "+ hex_number + " " + "with decimal value of "+ ICV);
        current_Token = new Token("Integer",hex_number, yyline);
        return current_Token;
            }
            // fall through
          case 30: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
