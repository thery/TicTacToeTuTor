package inria.org.tictactoetutor;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by thery on 03/07/15.
 */
public class BoardView extends View {
    public static final int EMPTY = 0;
    public static final int CROSS = 2;
    public static final int NOUGHT = 1;
    private boolean state = true;
    public static int[] val1 =
            new int[]{42369221, 551026688, 42469920, 1836, 1463837312, 2238989, 37748736, 134217730,
                    16, 469862912, 5, 0, 786432, 64, 1146361856, 2271297, -1525870454, 1920995360,
                    67191620, 827678728, 131589, 4478232, 0, 393216, 2260992, 323, 0, 731251012,
                    1335298, 180224, 80, 0, 240649488, 0, 0, 0, 0, 719324240, 21168226, 338427904,
                    16777233, 2, -1591592640, 1343226114, 573452, 33816576, -1073184638, 1090918992,
                    355730984, 115703889, 1612763905, 1140850704, 13647872, 1086326784, 420610304,
                    1342196740, 33604864, -1072954848, 4456480, 1074266112, 167780544, 1359479046,
                    218365956, 1393906176, 677938752, 1075872525, -1052770096, 42, 269090816, 24,
                    84738440, 0, 0, 1343753808, 64, 263168, 0, 0, 12288, 0, 0, 0, 805306368,
                    25723296, 537920781, 272650368, 38274064, -452984832, 67249792, -1607401468,
                    128, 0, 268435456, 935940, 0, 0, -1006612480, 1073741824, 2646020, 0, 0, 0, 0,
                    0, 0, 10485760, 1208222090, 4, 42336324, 0, 42467328, 1610892068, -2013224920,
                    1, 5296152, 67109377, 332, 229, 583011328, 49216, 2561, 32, 0, -2147471360, 0,
                    0, 16875520, 10, 25198592, 17581320, 337682961, 240157184, 8528488, 637676617,
                    2113537, 100993, 708837376, 8915490, 274769164, 1128292992, 1851262225,
                    436547860, 16793682, 218366272, 201361408, -1862266875, 269763665, 537810949,
                    -2134629888, 4260494, 1, -1602182092, 1350570080, -801106875, 827596800,
                    -2037857275, 34255058, 872418564, 32932, 3309568, 343, 85005612, 60162372,
                    960495616, 5417762, -1073741616, 536871946, 37748736, 1694498816, 175624, 0,
                    738363392, 171966471, -1543503872, 358719520, 12584209, 168841358, -1591592640,
                    -1241251200, 84055082, 11280384, 384, 133120, 16640, 33557764, 71323905,
                    -2147407776, 13647904, 524288, 134217728, 285213760, 67412352, 1610891266,
                    1124082216, 2228737, 2112, -1602224120, 218365953, 8654848, 0, -2078244603,
                    -2113887710, 6, 27295744, 0, 262656, 570425344, 82752, 0, 0, 70271531, 33554432,
                    272, 0, 134479872, 0, 0, 1073741824, 128, 1216630784, 1124082312, 777520401,
                    1141182480, 235009, -1607385088, 1065515, 677414480, 0, 0, 21233664, 918, 0,
                    1073741824, 1654800, 17825792, 2584, 0, 0, 0, 0, 0, 0, 851452032, 60162372,
                    285212672, 41344, 0, -889150976, -1978138351, 7503904, 33554432, -2143285228,
                    318832640, 805306368, 0, 1075851267, 134479889, 135266306, 8404992, 0, 2099212,
                    0, 0, 8930400, 1074792448, 1107312800, -2041556719, -2147407768, -1174203360,
                    1925195906, 6389763, -2009071088, 50, 0, 0, 205521920, 0, 0, -2142240768, 68,
                    677381184, 0, 0, 0, 0, 0, 0, -1610612736, 67143936, 3672, -2046802944, 2,
                    -2147483648, 71772162, 10627168, 137, 0, 0, 557064, 0, 0, -2013233152,
                    -2147483648, 5292040, 0, 0, 0, 0, 0, 0, 16777216, -2146959088, 8, 84672648, 0,
                    67108864, -1073183680, 268501072, 1, 0, 0, 8192, 0, 1610612736, 163904, 4104,
                    32, 0, 0, 0, 0, 134217728, 16, 16809984, 677380096, 65664, 40962, 29312,
                    1611005952, 2228225, 331912, 847249408, 86788, 290792000, -1778301947,
                    1073741827, 1378590769, 37765264, 553912320, 134479872, 0, 41977924, 0,
                    41943040, 8537604, 8, 545327268, 1694830869, 273853960, -1573305848, 738363435,
                    102277815, -1543495676, 41248, 0, 144, -1451091712, 0, -1577058304, 9554688,
                    656, 537403410, 0, 134217728, 74754, 0, 0, 301989888, 536870912, 419766337,
                    43904, -2004216024, -889150974, -1610612735, 538284316, 18884608, 1376,
                    1360351744, 677414464, 337675021, 679655939, -2147257664, 43008097, 1181696,
                    1342203936, -2111813500, 168593664, -1071120348, 268501090, 1080296961,
                    134221960, 1084227600, -1425211391, -1557486560, 426496, 677481003, -2046462905,
                    1746927617, 86016000, 0, -2147351932, 171982856, 120062214, -2142170060,
                    1393645124, 1073184, 1074004032, 142606544, 16797888, 1074010896, -444575487,
                    1109393920, 1076551692, 1024, 549668864, 22415880, 807944, 1107299588,
                    -2076179563, -1425735640, 13647872, 2146368, 0, 1052678, 289587200, 537919569,
                    0, 1779573652, -1073676272, 1051648, 512, 192, 719326288, 0, 679477248, 29376,
                    524, 436216024, 200960, 10252, 554696865, 1075838978, 21143808, -1073217520,
                    24576, 0, 1073741840, 13647872, 68162592, 1384513604, 67241984, 13, 2, 16384,
                    1243087120, 1140858880, 35816960, 2102320, 33554442, 0, 1073748488, 1073742032,
                    32, 168837120, 2230272, 26656, 134217728, 26, 1343782912, 80, 21759240, 2392129,
                    240123904, -1069538712, 196608, 2097224, 50331648, 805306368, 41728, 0,
                    -905969664, 134218497, -2097152000, 1157630336, -1609564148, 42209280, 2655808,
                    604045440, 1834, -2139095008, 1, 0, 1073741824, 2629632, 0, 1075871744, 49170,
                    402653186, 131104, 0, 0, 384, 0, 0, 1572864, 25165824, 536871960, 0, 139392,
                    16416, 1126170624, 2097156, 98304, -2147483648, 269533264, -1019082239,
                    -2132473824, -1878384090, 308290252, 134148, 134223880, 50331674, 2099728,
                    696288034, 480250368, -2143027136, 134502401, 24, 68683776, 2801984,
                    -2147382623, -1572863584, 281542770, 291577861, 1705984, 268296, 167772160,
                    67633152, 218366016, 17908224, 677381184, 1073783045, 4194512, 2048, 1073741824,
                    -1585442559, 1082130452, 573071364, 579158784, 162, 134217736, 106624, 67112196,
                    516, -1593835520, 35782656, 426496, -2147483648, 416, 290848768, -536063919,
                    548080896, -1978522732, -1419624408, 13642050, 49664, 6823960, 719324224,
                    -1383464832, 679584290, 16806592, 1682385168, 436207637, -1609039872, 84148225,
                    671875243, 109182982, 21143808, -2147203552, 536872194, 1635778664, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static int[]val2 =
            new int[] {548178149,-1429950454,42474066,1050412,373584593,-1582880084,437637404,
                    35668310,4201632,1494338372,1358958597,268435456,481187845,21255569,1242913686,
                    443714243,22876618,1921254721,84940356,134221400,1096161800,51269976,
                    -2013264636,268512258,1146147072,1074003990,20,731119684,1359311943,-1789516416,
                    1048787,81,240124176,0,134217728,-2142164864,537002213,-1429696998,273957906,
                    1094866949,4459816,-2146958444,167772200,1354994774,84551810,715923617,
                    -1860394585,5242885,24397608,1442938897,1637876500,-447380459,20,361831584,
                    1518600260,285427793,8576,-401846272,346117514,168960916,436734467,1431847254,
                    846,-2087447040,48795216,10240,-1019215872,2090,-1341513728,1140867100,5837251,
                    5308432,84934656,-1860391912,-1778301931,55465307,21233728,339738624,14688,0,
                    -1577050112,60162372,694714376,298494754,1611939921,619005241,202900752,
                    -2136866784,1431832712,-1574354098,-2105273301,1358958592,0,528385,0,
                    -2146959360,562041128,438305280,166026,0,2097152,162,0,0,663554,2228224,
                    268505411,-1577050102,2656417,2654216,0,-2004216824,1124073986,-1599987068,
                    1145426204,1432065537,-2142174708,537002177,-2144859046,-1810569899,-1018553821,
                    21235754,-2146958442,-1415564952,169869824,-1610612736,597002752,1076398610,
                    688565026,1112429656,546021945,-1945107796,10617000,103285123,137020224,
                    -2144744789,-1967128416,290069074,83984729,1443107460,1645215760,436996165,
                    1431847254,774,1494305280,-1470102463,271884629,135168,145031168,1175804076,
                    -1417537213,-2138961884,360973569,12517,138764288,-1400363764,0,0,684,
                    1146257408,1476726870,220743010,9699332,141066248,-1789515008,545673409,
                    548080906,240649488,-509476832,134392960,10368,671123456,719357527,-1396047742,
                    1157735178,-2010837976,10535072,721422402,-2128084984,201719808,681574571,
                    42074115,1096030720,55465304,1442840576,-1978613100,722207368,0,137020224,
                    1342177280,675498517,-1473246686,-2004217728,2,1099180204,-1425530237,10434,
                    0,-2102643712,0,-1409275124,100136,0,0,0,120062088,1355874320,67130884,5184,
                    -1778301952,358893352,1457881169,268489349,20736,1342246912,14,0,287866888,
                    33613056,-1073079776,340021930,1113064720,1141385541,134256129,34089088,
                    -745187840,178818640,2138373,1327108,0,132,0,1243611648,-2144837628,579241984,
                    162,0,679479296,0,0,8388608,648,1350567936,8388612,677937160,33557026,2592,
                    1073741824,-2136857980,-1592770552,1193814152,-2142173852,-1072408859,157291584,
                    378011776,1432521216,-1998256856,44094084,-452980478,1512047104,-2146779136,
                    165888,-2144862208,-2080333566,-2004876766,1443495946,-1907326060,722209512,
                    169907200,314583168,-805303768,-1430123856,673188466,1048576,81,35127568,0,
                    134217728,1124480,537002145,42502682,0,536870912,41472,0,0,169869824,33554432,
                    17908224,2097160,680042914,679479296,134217728,-1978661888,2228872,-1574795965,
                    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,15040593,207233026,8391400,648,
                    41953280,579111141,-1429696502,33557058,2592,-1979670528,1,0,35979264,4196480,
                    134286080,44600917,-1379204958,679544360,16777280,335555856,175286976,
                    -1525870134,1384387616,84956740,671436376,-1811938292,1753221120,1445462537,
                    -2041523835,-1978848544,1342246944,-1577050098,11272353,2654216,524288,
                    -1073344216,-905936342,1637876264,-452187835,-1597988216,34160642,738363432,
                    262785,-1407145203,-2113830102,21233666,-2146958442,723527784,169869824,
                    33554432,563366400,-2145350984,1757588274,679479296,-2013265920,468992,0,
                    1074003968,847257748,202375168,693460995,42477602,337813804,1241514502,
                    339739648,-1424752636,1126719690,1350731024,-1031777264,176720400,-1811929088,
                    8552480,170397760,136351744,170961602,0,537559050,10568192,33152,16,-2063597528,
                    -1039531998,17106944,671089664,-2027377664,1,671107624,332865,20,358719488,4,
                    -1582880084,437621020,1193820502,1118564,-1836771679,-2078973536,3196181,
                    480247808,4457873,1314216070,-2130702077,1342177280,1436731534,51655877,
                    717439674,1073745928,21647704,369098752,-1907338747,534600,32,134873856,
                    671088640,1359307847,-2062146176,1074020562,-2013233095,1756365318,84685125,
                    -1328504192,-2142174710,537002213,717786714,42467456,142606336,-2134543744,
                    -1609957202,442673856,1347454038,218644610,42213386,559632,671091234,33730752,
                    537395850,1637875752,-447380459,52,154751328,-1876391775,2736,-1405878272,130,
                    887444864,1084367492,-1593300285,10376,1655357440,-2102643694,43559600,0,
                    -1019215872,2090,145788928,175284930,0,0,0,-786653184,-1778301883,38687835,
                    12681297,-1944444926,-984244088,-1174203340,137020226,60162372,963149832,
                    33590178,2592,-2097110528,179962645,-1419608024,341338506,-1573306034,
                    -2111298399,541592592,143196322,-1019206654,-1976891350,10518569,-444575488,
                    438305280,-2145204082,165888,-2146959360,-1367292576,-1063253504,1729194,663554,
                    10616832,459,0,84934912,1613834,25903104,1217287517,-1996447192,-2136667604,
                    2228232,67895297,1653264416,218106378,-2079055711,-2077956795,-1073169885,
                    -2000617430,805437962,6463632,-1333613516,170154,596901888,-1073182550,
                    1233824592,269484576,-1979711488,-1431038719,1080197784,89680195,136348225,
                    2738827,-1602224128,293732960,272630797,0,17127528,402653184,1364214102,782,
                    -763079168,42502672,2099725,-1023410176,42,1314215936,170010691,276999220,
                    166026,179044352,717439397,1619700488,0,805306368,32936,168624128,-1526158304,
                    0,0,0,-2075131904,142737602,536872970,45088900,168853504,-1342150656,579469322,
                    0,176720400,-1405026270,107786,20608,1610942464,404925141,-1589378934,134485345,
                    10493952,129,671091200,69206280,1048580,0,5,5259264,136855872,1342177280,
                    675416592,673188386,0,657408,1073741824,-1593300927,-1602213752,573063168,10,
                    68427936,671091208,66824,0,10518528,0,-1610602464,267296,0,0,0,0,};

    private int[][] boards;
    private int[] hist;
    private int turn;
    private int current;
    private final Paint paint;
    private float height;
    private float width;
    private float size;
    private float circle;
    private boolean mode;
    private float history;
    private float historyS;
    private float border;
    private int soundID1;
    private int soundID2;
    private AudioManager audioManager;
    private SoundPool soundPool;
    private boolean loaded;

    public BoardView(BoardActivity bD, Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        height = 0;
        width = 0;
        mode = true;
        boards = new int[10][];
        boards[0] = new int[9];
        hist = new int[]{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY,
                Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY};
        turn = CROSS;
        state = false;
        current = 0;
        hist[current] = getColor(getNumber(boards[current]));
        audioManager =
                (AudioManager) context.getSystemService(context.AUDIO_SERVICE);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                loaded = true;
            }
        });
        soundID1 = soundPool.load(context, R.raw.sound1, 1);
        soundID2 = soundPool.load(context, R.raw.sound2, 1);


    }
    public void init() {
        for (int i = 1; i < 10; i++) {
            hist[i] = Color.GRAY;
            boards[i] = null;
        }
        turn = CROSS;
        state = false;
        current = 0;
        hist[current] = getColor(getNumber(boards[current]));
        invalidate();
    }
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void setActive() {

    }
    public static boolean hasWon(int[] board, int turn) {
        return (board[0] == turn && board[1] == turn && board[2] == turn)
                || (board[3] == turn && board[4] == turn && board[5] == turn)
                || (board[6] == turn && board[7] == turn && board[8] == turn)
                || (board[0] == turn && board[3] == turn && board[6] == turn)
                || (board[1] == turn && board[4] == turn && board[7] == turn)
                || (board[2] == turn && board[5] == turn && board[8] == turn)
                || (board[0] == turn && board[4] == turn && board[8] == turn)
                || (board[2] == turn && board[4] == turn && board[6] == turn);

    }
    public static int getColor(int num) {
        if (0 != (val1[num >> 5] & (1 << (num & ((1 << 5) - 1))))) {
            if (0 != (val2[num >> 5] & (1 << (num & ((1 << 5) - 1))))) {
                return Color.WHITE;
            } else {
                return Color.RED;
            }
        }
        if (0 != (val2[num >> 5] & (1 << (num & ((1 << 5) - 1))))) {
            return Color.BLUE;
        }
        return Color.GRAY;
    }

    public static int getNumber(int[] board) {
        int n = 0;
        for (int i = 8; 0 <= i; i--) {
            n = n * 3 + board[i];
        }
        return n;
    }

    @Override
    protected void onSizeChanged(int w, int h, int ow, int oh) {
        System.out.println("change Size");
        System.out.println("w = " + w + ", h = " + h);
        height = h;
        width = w;
        size = Math.min(height, width);
        if (Math.max(height, width) - history < size) {
            size = Math.max(height, width) - history;
        }
        border = size / 70;
        if (size == height) {
            mode = true;
            historyS = size + (width - height - history) / 2;
        } else {
            mode = false;
            historyS = size + (height - width - history) / 2;
        }
        mode = size == height;
        circle = size / 6 - border;
        history = size / 11;
    }

    protected void onDraw(Canvas canvas) {
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(border);
        paint.setColor(Color.BLACK);
        canvas.drawRect(0, 0, width, height, paint);
        paint.setColor(Color.DKGRAY);
        canvas.drawRect(0, 0, size, size, paint);
        if (mode) {
            paint.setColor(Color.DKGRAY);
            canvas.drawRect(historyS, 0,
                    historyS + history, size, paint);
        }else{
            paint.setColor(Color.DKGRAY);
            canvas.drawRect(0, historyS, size,
                    historyS + history, paint);
        }
        if (mode) {
            for (int k = 0; k < 10; k++) {
                paint.setColor(hist[k]);
                paint.setStrokeWidth(border);
                canvas.drawCircle(historyS + history / 2, (size * (2 * k + 1)) / 20,
                        (history - border) / 2, paint);
                paint.setColor(Color.BLACK);
                canvas.drawCircle(historyS + history / 2, (size * (2 * k + 1)) / 20,
                        (history - 2 * border) / 2, paint);

            }
        }
        else {
            for (int k = 0; k < 10; k++) {
                paint.setColor(hist[k]);
                paint.setStrokeWidth(border);
                canvas.drawCircle((size * (2 * k + 1)) / 20, historyS + history / 2,
                        (history - border) / 2, paint);
                paint.setColor(Color.BLACK);
                canvas.drawCircle((size * (2 * k + 1)) / 20, historyS + history / 2,
                        (history - 2 * border) / 2, paint);

            }
        }
        if (state) {
            int k = 0;
            int val = getNumber(boards[current]);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setStrokeWidth(border);
                    paint.setColor(Color.GRAY);
                    if (boards[current][k] == EMPTY) {
                      paint.setColor(getColor(val + turn * (int) Math.pow(3, k)));
                    }
                    canvas.drawCircle((2 * i + 1) * (border + circle),
                            (2 * j + 1) * (border + circle), circle, paint);
                    paint.setColor(Color.BLACK);
                    canvas.drawCircle((2 * i + 1) * (border + circle),
                            (2 * j + 1) * (border + circle), circle - border, paint);
                    if (boards[current][k] == EMPTY) {
                        boards[current][k] = turn;
                        drawBoard(new int[9], i * (2 * (circle + border)),
                                j * (2 * (circle + border)), 1, canvas, paint);
                        boards[current][k] = EMPTY;
                    }
                    k++;
                }
            }
        } else {
            System.out.println("Number = " + getNumber(boards[current]));
            paint.setColor(hist[current]);
            canvas.drawCircle(3 * (border + circle),
                    3 * (border + circle), 2 * circle, paint);
            paint.setColor(Color.BLACK);
            canvas.drawCircle(3 * (border + circle),
                    3 * (border + circle), 2 * circle - border, paint);
            drawBoard(new int[9], (circle + border), (circle + border), 2, canvas, paint);
        }

    }
    public void drawBoard(int[] board, float x, float y, int scale, Canvas c, Paint p) {
        p.setStrokeWidth((scale * border) / 2);
        p.setColor(Color.WHITE);
        System.out.println("circle=" + circle);
        float cx = x + (scale * (circle + border));
        float cy = y + (scale * (circle + border));
        float cz =  (scale * (circle - border)) / (float) Math.sqrt(2);
        c.drawLine(cx - cz, cy - cz / 3, cx + cz, cy - cz / 3, p);
        c.drawLine(cx - cz / 3, cy - cz, cx - cz / 3, cy + cz, p);
        c.drawLine(cx - cz, cy + cz / 3, cx + cz, cy + cz / 3, p);
        c.drawLine(cx + cz / 3, cy - cz, cx + cz / 3, cy + cz, p);

        int k = 0;
        float f =  (cz - scale * 2 * border) / 3;
        float s = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                float cx1 = cx + ((i - 1) * 2 * cz) / 3;
                float cy1 = cy + ((j - 1) * 2 * cz) / 3;
                if (boards[current][k] == NOUGHT) {
                    p.setColor(Color.RED);
                    p.setStyle(Paint.Style.STROKE);
                    c.drawCircle(cx1, cy1, f, p);
                } else if (boards[current][k] == CROSS) {
                    p.setColor(Color.BLUE);
                    c.drawLine(cx1 - f, cy1 + f, cx1 + f, cy1 - f, p);
                    c.drawLine(cx1 - f, cy1 - f, cx1 + f, cy1 + f, p);

                }
                k++;
            }
        }
    }
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        int maskedAction = event.getActionMasked();
        switch (maskedAction) {

            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_DOWN: {
                float x = event.getX();
                float y = event.getY();
                if (x < size && y < size) {
                    if (state) {
                        int k = (int) (x / ((border + circle) * 2));
                        int j = (int) (y / ((border + circle) * 2));
                        if ((Math.pow(x - (2 * k + 1) * (border + circle), 2) +
                                Math.pow(y - (2 * j + 1) * (border + circle), 2))
                                < Math.pow(circle - border, 2)) {
                            int val = 3 * k + j;
                            if (boards[current][val] == EMPTY) {
                                if (boards[current + 1] != null && boards[current + 1][val] == EMPTY) {
                                    for (int i = current + 1; i < 10; i++) {
                                        hist[i] = Color.GRAY;
                                        boards[i] = null;
                                    }
                                }
                                current++;
                                boards[current]= boards[current - 1].clone();
                                boards[current][val] = turn;
                                hist[current] = getColor(getNumber(boards[current]));
                                state = false;
                                turn = turn == CROSS ? NOUGHT : CROSS;
                                playSound(soundID1);
                                invalidate();
                            } else {
                                playSound(soundID2);
                            }
                        } else {
                            playSound(soundID1);
                            state = !state;
                            invalidate();

                        }
                    } else {
                        if (Math.pow(x - 3 * (border + circle), 2) +
                                Math.pow(y - 3 * (border + circle), 2)
                                < 4 * Math.pow(circle - border, 2)) {
                            if (!hasWon(boards[current], CROSS) && !hasWon(boards[current], NOUGHT)
                                    && current != 9) {
                                state = !state;
                                playSound(soundID1);
                                invalidate();
                            } else {
                                playSound(soundID2);
                            }
                        }
                    }
                } else {
                    if (mode) {
                        if (historyS < x && x < history + historyS) {
                            int k = (int) (20 * y / (size * 2));
                            if (4 * (Math.pow(x - (historyS + history/2), 2) +
                                     Math.pow(y - (size * (2 * k + 1)) / 20, 2))
                                    < 4 * Math.pow((history - border) / 2, 2)) {
                                if (boards[k] != null) {
                                    current = k;
                                    state = false;
                                    turn = (k == (k / 2) * 2) ? CROSS : NOUGHT;
                                    playSound(soundID1);
                                    invalidate();
                                } else {
                                    playSound(soundID2);
                                }
                            }
                        }
                    }else {
                        if (historyS < y && y < history + historyS) {
                            int k = (int) (20 * x / (size * 2));
                            if (4 * (Math.pow(y - (historyS + history/2), 2) +
                                    Math.pow(x - (size * (2 * k + 1)) / 20, 2))
                                    < 4 * Math.pow((history - border) / 2, 2)) {
                                if (boards[k] != null) {
                                    current = k;
                                    state = false;
                                    turn = (k == (k / 2) * 2) ? CROSS : NOUGHT;
                                    playSound(soundID1);
                                    invalidate();
                                } else {
                                    playSound(soundID2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private void playSound(int sid) {
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        if (loaded) {
            soundPool.play(sid, volume, volume, 1, 0, 1f);
        }
    }



}
