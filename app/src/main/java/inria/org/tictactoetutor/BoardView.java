package inria.org.tictactoetutor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    public static final int CROSS = 1;
    public static final int NOUGHT = 2;
    private boolean state = true;
    public static int[] val1 =
            new int[]{42369221, 550502400, 42469920, 1836, 1463837312,
                    2238989, 37748736, 134217730, 16, 469862912, 5, 0, 524288, 64,
                    1146361856, 2271297, 621613194, 1920995360, 67191620, 827613192,
                    131589, 4478232, 0, 0, 2260992, 323, 0, 731251012, 1335298, 163840, 80,
                    0, 240649488, 0, 0, 0, 0, 719324240, 21168226, 338165760, 16777233, 2,
                    -1591592640, 1343226114, 573452, 33816576, -1073184766, 1090523728,
                    355730984, 115703889, 1612763905, 1140850704, 9453568, 1077936128,
                    420610304, 1342196740, 33604864, -1072954848, 4456480, 1074266112,
                    8384, 1359479046, 151257092, 1393906176, 677938752, 2130701,
                    -1069547376, 42, 269090816, 24, 84738440, 0, 0, 1343753808, 64, 263168,
                    0, 0, 8192, 0, 0, 0, 536870912, 25723040, 537920781, 272650368,
                    38274064, -452984832, 67249792, -1607401468, 128, 0, 268435456, 935940,
                    0, 0, -1006612480, 1073741824, 2646020, 0, 0, 0, 0, 0, 0, 10485760,
                    1208222090, 4, 42336324, 0, 42467328, 1610892068, -2013224920, 1,
                    5263384, 67109377, 76, 229, 549455872, 49216, 2560, 32, 0, -2147475456,
                    0, 0, 65536, 10, 25198592, 803840, 2138641, 240124416, 8528488,
                    637668425, 2097153, 100992, 708837376, 8915490, 274769164, 1128292992,
                    1851262225, 436547860, 16793682, 218366272, 201361408, -1862266875,
                    269763665, 537810949, -2134629888, 4260494, 1, -1602182092, 1350570080,
                    -1879043003, 827596800, -2037857275, 34222290, 872418564, 32932,
                    3309568, 343, 85005608, 60162372, 960495616, 5417762, -2147483440,
                    536871946, 37748736, 1694498816, 175624, 0, 738363392, 167772167,
                    -1543503872, 358719520, 8389888, 167792778, -1593689792, -1274805760,
                    84055050, 11280384, 384, 133120, 16640, 33556740, 71323905, -2147407776,
                    13647904, 524288, 0, 1088, 67412096, 1610891266, 1124082216, 2228737,
                    2112, -1602224120, 150994945, 8654848, 0, -2078244603, -2113887710, 4,
                    27295744, 0, 262656, 570425344, 82752, 0, 0, 70271530, 33554432, 272, 0,
                    134479872, 0, 0, 1073741824, 128, 1216630784, 1124082312, 777520401,
                    1141182480, 235009, -1607385088, 1065515, 677414480, 0, 0, 21233664,
                    918, 0, 1073741824, 1654800, 17825792, 2584, 0, 0, 0, 0, 0, 0,
                    851452032, 60162372, 285212672, 41344, 0, -889150976, -1978138351,
                    7503904, 0, -2143285228, 318832640, 536870912, 0, 1075847170, 134479889,
                    135266306, 8404992, 0, 2099208, 0, 0, 8930368, 1074792448, 1107312800, -
                    2041556719, -2147407768, -1174203360, 1925195906, 6389763, -2009071088,
                    50, 0, 0, 205521920, 0, 0, -2142240768, 68, 677381184, 0, 0, 0, 0, 0, 0,
                    -1610612736, 67143936, 3672, -2046802944, 2, -2147483648, 71772162,
                    10627168, 137, 0, 0, 557064, 0, 0, -2013233152, -2147483648, 5292040, 0,
                    0, 0, 0, 0, 0, 16777216, -2146959088, 8, 84672520, 0, 67108864,
                    -1073183680, 268501072, 1, 0, 0, 8192, 0, 1073741824, 163904, 4104, 32,
                    0, 0, 0, 0, 134217728, 16, 16809984, 677380096, 65664, 40962, 29312,
                    1611005952, 2228225, 331912, 847249408, 86788, 290792000, -1778301947,
                    1073741827, 1378590769, 37765264, 553912320, 134479872, 0, 41977924, 0,
                    33554432, 8537092, 8, 545327268, 1694830869, 273853960, -1573305848,
                    738363435, 102277815, -1543495676, 41248, 0, 144, -1451091712, 0,
                    -1577058304, 9554688, 656, 537403410, 0, 0, 74754, 0, 0, 301989888,
                    536870912, 419766337, 43904, -2004216576, -889150974, -1610612735,
                    538284316, 18884608, 1376, 1360351744, 673219072, 337675021, 545438211,
                    -2147265984, 43008097, 1181696, 26656, 2099328, 168296704, 1075839012,
                    268501058, 4457472, 4232, 1084227600, -2096365567, -1557486560, 295424,
                    677481003, -2046462905, 1746927617, 86016000, 0, -2147351932, 37765128,
                    120062212, -2142170060, 1393645124, 1073184, 262208, 142606480,
                    16797888, 1074010896, -444575487, 1109393920, 1076551692, 1024,
                    549603328, 17170440, 807944, 1107298560, -2076179563, -1425735640,
                    9437184, 2146368, 0, 1052676, 289570816, 537919569, 0, 1779573652,
                    -2147418096, 1050624, 512, 0, 719326288, 0, 679477248, 29376, 520,
                    436216016, 200960, 10248, 554696865, 1075838978, 21143808, -1073217520,
                    24576, 0, 16, 9453568, 68162592, 1384513604, 133120, 9, 2, 16384,
                    1208483840, 1140858880, 35816960, 2102320, 33554442, 0, 4616,
                    1073741968, 32, 168837120, 2230272, 26656, 0, 26, 1343782912, 80,
                    21759232, 2392129, 240123904, -1069538712, 131072, 2097224, 33554432,
                    536870912, 41472, 0, -905969664, 134218241, -2113929216, 67111296,
                    -1610612724, 33554432, 2623040, 604045440, 1826, -2139095008, 1, 0,
                    1073741824, 2629632, 0, 1075871744, 49170, 268435458, 131104, 0, 0, 256,
                    0, 0, 1048576, 25165824, 536871960, 0, 139264, 16416, 1126170624,
                    2097156, 98304, 0, 49216, 2560, -2132475872, 269091366, 308290248,
                    131072, 6152, 33554432, 2048, 151028224, 402655744, -2143289280,
                    134502401, 24, 68159488, 2097152, 100864, -1572864000, 281542770,
                    291577861, 0, 268288, 134217728, 0, 150994944, 17908224, 677381184,
                    1073783045, 208, 2048, 0, -1602224128, 1082130436, 573071364, 579158784,
                    162, 8, 106624, 2304, 516, -1593835520, 35782656, 426496, -2147483648,
                    416, 290848768, -1610088367, 548080896, 168960916, -1419624448,
                    13642050, 512, 6823960, 706740224, -1392508928, 107042, 29376,
                    1682385168, 436207637, -1609564160, 84148225, 671088810, 109182982,
                    21143808, -2147203552, 536872194, 1635778664, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[]val2 =
            new int[]{548178149, -1429950454, 42474066, 1050412, 373584593,
                    -1582880084, 303386900, 35668310, 4201632, 1494338372, 1358958597,
                    268435456, 346707973, 17061137, 1242913410, 443714243, 22876618,
                    1921254721, 84940356, 134221400, 1096159752, 51269976, -2013265664,
                    268512258, 1146142976, 1074003990, 20, 731119684, 1359311943,
                    -1789516416, 1048787, 81, 240124176, 0, 134217728, -2142164864,
                    537002149, -1429697000, 273957906, 1094866949, 4459816, -2146958444,
                    167772200, 1354994774, 17442946, 715923617, -1860394713, 4194309,
                    24397608, 1442938897, 1629487892, -447380459, 20, 286332064,
                    1518600260, 285427793, 8576, -401846272, 77676810, 168960916,
                    526338, 1431830870, 846, -2087447040, 48795216, 8192, -1035993088,
                    2090, -1341513728, 1140867100, 5837251, 5308432, 84934656,
                    287091736, -2113846251, 55465306, 21233728, 339738624, 10592, 0,
                    -1577050112, 42074436, 694157320, 298494498, 1611939921, 619005241,
                    202900752, -2136866784, 1431832712, -1574354098, -2105536469,
                    1358958592, 0, 528385, 0, -2146959360, 562041128, 404750848, 166026,
                    0, 2097152, 162, 0, 0, 532482, 2228224, 268505411, -1577050102,
                    2656416, 2654216, 0, -2004216824, 1124073986, -1599987068,
                    1145131292, 1157862913, -2142174708, 537002177, 2623578,
                    -1811618495, 657954, 21235752, -2146958718, -1432346264, 167772672,
                    -1610612736, 570493440, 1076398082, 151552000, 1074680832, 9151033,
                    -1945107796, 10617000, 103285123, 2097152, 2738850, -1967128544,
                    290069074, 83984729, 1443107460, 1645215760, 436996165, 1431847254,
                    774, 1494305280, -1470102463, 271884629, 135168, 145031168,
                    1175804076, -1417537213, -2138961884, 360973569, 12517, 138764288,
                    -1400363764, 0, 0, 684, 1146257408, 1476726870, 220743010, 9699332,
                    140541960, -1789515008, 545411265, 548080906, 240649232, -509476832,
                    134392960, 10368, 671123456, 715162199, -1404436350, 83993354,
                    -2010837976, 10535072, 721422402, -2128084984, 201719808, 681574570,
                    42074115, 1096030720, 55465296, 1442840576, -1978613100, 722207368,
                    0, 137020160, 1342177280, 671287829, -1473246686, -2004217728, 2,
                    25438380, -1475861885, 10434, 0, -2102643712, 0, -1409275124,
                    100136, 0, 0, 0, 120062088, 1355874320, 67130884, 5184, -1778301952,
                    358893352, 1453686865, 53893, 20736, 1342246912, 14, 0, 287866888,
                    33613056, -1073079776, 340021930, 1113064720, 1141385541, 134256129,
                    34089088, -745187840, 178818640, 2138369, 1327108, 0, 132, 0,
                    1243611648, -2144837628, 579241984, 162, 0, 679477248, 0, 0,
                    8388608, 648, 1350567936, 8388612, 673218568, 33557026, 2592,
                    1073741824, -2136857980, -1592770552, 1160259720, -2142174140,
                    -2146150683, 157291584, 378011776, 1432488448, -1998257880,
                    44077696, 603980034, 1512047104, -2146795520, 133120, -2144862208,
                    -2080333566, -2004876766, 1443495946, -1907326060, 722209512,
                    169907200, 314583168, -1879045592, -1430123856, 673188466, 1048576,
                    81, 35127552, 0, 134217728, 1124480, 537002145, 42502682, 0,
                    536870912, 41472, 0, 0, 169869824, 33554432, 17908224, 2097160,
                    680042658, 679479296, 134217728, -1978661888, 2228872, -1574795965,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 10518609, 207233026, 8391400, 648, 41953280, 579111141,
                    545820682, 33555010, 2080, 167813120, 1, 0, 35651584, 4196480,
                    134285568, 44600917, -1580531550, 679544360, 16777280, 335553808,
                    175284352, 84742602, 1384387616, 84956740, 671436376, -1811938292,
                    1753221120, 1445462537, -2041523835, -1978848608, 1342181408,
                    -1577050110, 11272353, 2129920, 524288, -2147086040, 1241547306,
                    1637876264, -452187835, -1597988216, 34160642, 738363432, 262785,
                    -1407145203, -2113830102, 17039362, -2146958442, 723527784,
                    169869824, 33554432, 563366400, -2145350984, 1757588274, 679479296,
                    -2147483648, 468992, 0, 1073741824, 847257748, 202375168, 693460995,
                    42477602, 337813764, 1241514502, 272630784, -1424752636, 1126719690,
                    1350731024, -1031777264, 176720384, -1811931136, 8552480, 170397760,
                    136351744, 170961538, 0, 655370, 10567680, 33152, 16, -2063597528,
                    1074266146, 17104896, 1024, -2027377664, 1, 671107624, 332865, 16,
                    358719488, 4, -1582880084, 303403292, 1193820484, 1118564,
                    -1836771679, 68509984, 2147585, 480247808, 4457873, 1314216070,
                    -2130702077, 1342177280, 1436731534, 51655813, 717374138, 8,
                    4870488, 369098752, -1907338747, 534600, 32, 134742528, 671088640,
                    1359299653, -2062146176, 1074020562, -2013233095, 1756365318,
                    84422981, -1328512384, -2142174710, 537002021, 717786712, 42467456,
                    142606336, -2138738048, -1609957206, 442673856, 1343259734,
                    151519362, 42213386, 559632, 671091234, 33730688, 537395848, 40,
                    -1539309552, 0, 154751328, -1876391775, 2736, -2010906624, 130,
                    616579072, 1075978752, -1593302910, 10376, 1655357440, -2102647790,
                    10004512, 0, -1073741824, 42, 145788928, 175284930, 0, 0, 0,
                    -786653184, -1778301883, 38683666, 12681297, -1944444926,
                    -984539000, -1442709452, 136872514, 43385156, 694190088, 33589922,
                    2592, -2097110528, 178913813, -1572700120, 67135882, -1574354932,
                    -2113395552, 541592592, 143196322, 9218, -2013265888, 2097161,
                    -1518317312, 404750848, -2145204082, 165888, -2146959360,
                    -1367292576, -2136995328, 1729194, 532482, 10616832, 331, 0,
                    84934912, 1089546, 25821184, 1217287517, 16818728, -2145058296,
                    2228232, 67371009, 1652559904, 218105858, 68419617, 49216, 526882,
                    -2000617440, 268567050, 6463632, 537001984, 39048, 33554432,
                    1073743914, 1224770112, 269484544, -1979711488, -1474030335,
                    1077936280, 68176129, 2097153, 117248, -1602224128, 293732960,
                    272630797, 0, 350208, 402653184, 1363165526, 522, -763079168,
                    42502672, 2099725, 0, 40, 173359104, 141314, 276999204, 166026,
                    179044352, 671089061, 1074307080, 0, 805306368, 32936, 168624128,
                    -1526158304, 0, 0, 0, -2075131904, 142737602, 536872970, 45088900,
                    168853504, -1342150656, 579338250, 0, 167807488, -1405026304,
                    107786, 20608, 1610942464, 402827285, -1589379072, 134485345,
                    10493952, 129, 671091200, 69206280, 1048580, 0, 4, 0, 2621440,
                    1342177280, 675416592, 673188386, 0, 655360, 0, 532544, 545259528,
                    573063168, 10, 68427936, 2560, 66816, 0, 10485760, 0, -1610602464,
                    267296, 0, 0, 0, 0};
    private int[][] boards;
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
    public BoardView(BoardActivity bD, Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        height = 0;
        width = 0;
        mode = true;
        boards = new int[10][];
        boards[0] = new int[9];
        turn = CROSS;
        state = false;
        current = 0;
    }
    public void init() {

    }
    public void setActive() {

    }
    @Override
    protected void onDraw(Canvas canvas) {
        if ((canvas.getHeight() != height) || (canvas.getWidth() == width)) {
            System.out.println("change Size");
            height = canvas.getHeight();
            width = canvas.getWidth();
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
//            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
        }
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
                paint.setColor(Color.GRAY);
                canvas.drawCircle(historyS + history / 2, (size * (2 * k + 1)) / 20,
                        (history - border) / 2, paint);
                paint.setColor(Color.BLACK);
                canvas.drawCircle(historyS + history / 2, (size * (2 * k + 1)) / 20,
                        (history - 2 * border) / 2, paint);

            }
        } else {
            for (int k = 0; k < 10; k++) {
                paint.setColor(Color.GRAY);
                canvas.drawCircle((size * (2 * k + 1)) / 20, historyS + history / 2,
                        (history - border) / 2, paint);
                paint.setColor(Color.BLACK);
                canvas.drawCircle((size * (2 * k + 1)) / 20, historyS + history / 2,
                        (history - 2 * border) / 2, paint);

            }
        }
        if (state) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    paint.setColor(Color.GRAY);
                    canvas.drawCircle((2 * i + 1) * (border + circle),
                            (2 * j + 1) * (border + circle), circle, paint);
                    paint.setColor(Color.BLACK);
                    canvas.drawCircle((2 * i + 1) * (border + circle),
                            (2 * j + 1) * (border + circle), circle - border, paint);
                }
            }
            int k = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
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
            paint.setColor(Color.GRAY);
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
                                current++;
                                boards[current]= boards[current - 1].clone();
                                boards[current][val] = turn;
                                state = false;
                                turn = turn == CROSS ? NOUGHT : CROSS;
                                invalidate();
                            }
                        } else {
                            state = !state;
                            invalidate();
                        }
                    } else {
                        if (Math.pow(x - 3 * (border + circle), 2) +
                                Math.pow(y - 3 * (border + circle), 2)
                                < 4 * Math.pow(circle - border, 2)) {
                            state = !state;
                            invalidate();
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
                                    invalidate();
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
                                    invalidate();
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }



}