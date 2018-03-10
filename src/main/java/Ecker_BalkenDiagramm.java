import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

    public class Ecker_BalkenDiagramm {

        public static void main(String[] args) throws IOException {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics tg = screen.newTextGraphics();

            final int FROMX = 8;

            int value1  = (int) Math.floor(Math.random() * 40 + FROMX);
            int value2  = (int) Math.floor(Math.random() * 40 + FROMX);
            int value3  = (int) Math.floor(Math.random() * 40 + FROMX);
            int value4  = (int) Math.floor(Math.random() * 40 + FROMX);
            int value5  = (int) Math.floor(Math.random() * 40 + FROMX);

            screen.startScreen();

            tg.putString(0, 2, "Balkendiagramm");

            drawVerticalBar(tg, FROMX, value1, 3);
            displayValue(tg, 1);

            drawVerticalBar(tg, FROMX, value2, 4);
            displayValue(tg, 2);

            drawVerticalBar(tg, FROMX, value3, 5);
            displayValue(tg, 3);

            drawVerticalBar(tg, FROMX, value4, 6);
            displayValue(tg, 4);

            drawVerticalBar(tg, FROMX, value5, 7);
            displayValue(tg, 5);


            screen.refresh();
            screen.readInput();
            screen.stopScreen();
        }

        private static void displayValue(TextGraphics tg, int value) {
            tg.setForegroundColor(TextColor.ANSI.WHITE);
            tg.putString(0, value + 2, "Wert " + value);
        }

        private static void drawVerticalBar(TextGraphics tg, int fromX, int toX, int y) {
            tg.setForegroundColor(TextColor.ANSI.MAGENTA);
            tg.drawRectangle(new TerminalPosition(fromX, y), new TerminalSize(toX-fromX, 1), Symbols.BLOCK_SOLID);
        }
    }
