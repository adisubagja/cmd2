import java.util.Random;

public interface Res  {

	int WIDTH = 29;
    int HEIGHT = 13;

    char BLACK = '0';
    char WHITE = '1';
    char GRAY_25 = '2';
    char GRAY_50 = '3';
    char GRAY_75 = '4';
    char RED = '5';
    char GREEN = '6';
    char BLUE = '7';
    char PINK = '8';
    char YELLOW = '9';

    char[] SPRITES = new String("01234567891111111111111111111101010101011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111").toCharArray();
	char[] ACT = new String("94333333499999999900000009999937777773999999990000000009999377711739999999900000100099993771117399999999000010100999937111113999999990010101009999377777739999999000111110009993777777399999990010000010099943333334999999901100000110999999999999999999900000000099944444444444444444055555550444888888888888888888022022088888888888888888888888000008888888888888888888888888888888888").toCharArray();
	char[] face1 = new String("11101110222222222222202201110110201022220022210022202201021110110222021221112022022011001111102222000210002220220111111110220201002110002202201111111102002211021110022122001111011101022100111000221002200102011111021111111112210022221101111111012111112122002220211111111110111000111222022220111110111020111001112201022220111020102220011110022010222220111011022010000002200110222").toCharArray();
	char[] chess = new String("21212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212121212").toCharArray();

}