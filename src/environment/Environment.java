package environment;

import main.KeyRegister;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static util.Function.findIntersect;
import static util.Function.loadImg;

public class Environment {
    KeyRegister kr;
    BufferedImage bg;

    Car plr;
    public ArrayList<Line> lineBorder = new ArrayList<>();

    public Environment(KeyRegister kr) {
        this.kr = kr;
        this.plr = new Car(kr);
        this.bg = loadImg("res/race.png");
        setBorder();
    }

    private void setBorder() {
        lineBorder.add(new Line(55, 106, 52, 248));
        lineBorder.add(new Line(55, 106, 65, 70));
        lineBorder.add(new Line(65, 68, 79, 50));
        lineBorder.add(new Line(79, 51, 135, 24));
        lineBorder.add(new Line(123, 29, 159, 22));
        lineBorder.add(new Line(159, 22, 199, 22));
        lineBorder.add(new Line(199, 22, 250, 33));
        lineBorder.add(new Line(250, 33, 291, 54));
        lineBorder.add(new Line(293, 54, 339, 100));
        lineBorder.add(new Line(339, 100, 379, 155));
        lineBorder.add(new Line(378, 155, 408, 188));
        lineBorder.add(new Line(408, 188, 444, 204));
        lineBorder.add(new Line(443, 204, 475, 204));
        lineBorder.add(new Line(475, 204, 523, 184));
        lineBorder.add(new Line(523, 184, 591, 141));
        lineBorder.add(new Line(591, 141, 657, 100));
        lineBorder.add(new Line(659, 100, 711, 71));
        lineBorder.add(new Line(711, 71, 772, 55));
        lineBorder.add(new Line(772, 55, 820, 51));
        lineBorder.add(new Line(820, 51, 875, 60));
        lineBorder.add(new Line(875, 59, 927, 86));
        lineBorder.add(new Line(927, 86, 935, 124));
        lineBorder.add(new Line(935, 124, 935, 204));
        lineBorder.add(new Line(935, 204, 974, 254));
        lineBorder.add(new Line(974, 254, 994, 321));
        lineBorder.add(new Line(994, 321, 982, 376));
        lineBorder.add(new Line(980, 376, 955, 396));
        lineBorder.add(new Line(955, 396, 902, 407));
        lineBorder.add(new Line(902, 408, 795, 413));
        lineBorder.add(new Line(795, 413, 728, 434));
        lineBorder.add(new Line(728, 434, 745, 478));
        lineBorder.add(new Line(745, 478, 739, 496));
        lineBorder.add(new Line(739, 496, 708, 532));
        lineBorder.add(new Line(708, 531, 714, 545));
        lineBorder.add(new Line(714, 545, 885, 643));
        lineBorder.add(new Line(885, 643, 939, 680));
        lineBorder.add(new Line(939, 680, 952, 700));
        lineBorder.add(new Line(952, 700, 943, 716));
        lineBorder.add(new Line(943, 716, 831, 736));
        lineBorder.add(new Line(831, 736, 796, 739));
        lineBorder.add(new Line(796, 739, 675, 728));
        lineBorder.add(new Line(675, 728, 512, 732));
        lineBorder.add(new Line(512, 732, 347, 739));
        lineBorder.add(new Line(347, 738, 226, 734));
        lineBorder.add(new Line(226, 734, 163, 724));
        lineBorder.add(new Line(163, 724, 107, 699));
        lineBorder.add(new Line(107, 699, 74, 656));
        lineBorder.add(new Line(74, 656, 52, 603));
        lineBorder.add(new Line(51, 603, 49, 551));
        lineBorder.add(new Line(49, 551, 79, 457));
        lineBorder.add(new Line(79, 457, 98, 427));
        lineBorder.add(new Line(99, 428, 131, 413));
        lineBorder.add(new Line(131, 413, 174, 421));
        lineBorder.add(new Line(174, 421, 235, 452));
        lineBorder.add(new Line(235, 452, 343, 509));
        lineBorder.add(new Line(343, 509, 368, 507));
        lineBorder.add(new Line(368, 507, 389, 482));
        lineBorder.add(new Line(389, 482, 227, 425));
        lineBorder.add(new Line(227, 425, 129, 375));
        lineBorder.add(new Line(129, 375, 82, 328));
        lineBorder.add(new Line(82, 328, 57, 276));
        lineBorder.add(new Line(57, 276, 52, 248));
        lineBorder.add(new Line(149, 253, 150, 170));
        lineBorder.add(new Line(151, 169, 174, 127));
        lineBorder.add(new Line(174, 127, 203, 116));
        lineBorder.add(new Line(203, 116, 247, 135));
        lineBorder.add(new Line(247, 135, 302, 201));
        lineBorder.add(new Line(302, 201, 366, 288));
        lineBorder.add(new Line(366, 288, 399, 317));
        lineBorder.add(new Line(399, 317, 446, 330));
        lineBorder.add(new Line(446, 330, 507, 315));
        lineBorder.add(new Line(507, 315, 607, 258));
        lineBorder.add(new Line(607, 258, 705, 198));
        lineBorder.add(new Line(705, 198, 761, 171));
        lineBorder.add(new Line(761, 171, 826, 156));
        lineBorder.add(new Line(826, 156, 843, 156));
        lineBorder.add(new Line(845, 156, 861, 192));
        lineBorder.add(new Line(861, 192, 868, 225));
        lineBorder.add(new Line(867, 224, 879, 248));
        lineBorder.add(new Line(879, 248, 908, 288));
        lineBorder.add(new Line(908, 288, 929, 317));
        lineBorder.add(new Line(929, 317, 927, 328));
        lineBorder.add(new Line(927, 328, 867, 342));
        lineBorder.add(new Line(867, 342, 743, 349));
        lineBorder.add(new Line(743, 349, 685, 361));
        lineBorder.add(new Line(685, 361, 650, 374));
        lineBorder.add(new Line(650, 374, 612, 416));
        lineBorder.add(new Line(612, 416, 610, 430));
        lineBorder.add(new Line(610, 430, 617, 444));
        lineBorder.add(new Line(617, 444, 642, 466));
        lineBorder.add(new Line(642, 466, 647, 477));
        lineBorder.add(new Line(647, 477, 640, 496));
        lineBorder.add(new Line(640, 496, 612, 527));
        lineBorder.add(new Line(612, 527, 612, 584));
        lineBorder.add(new Line(612, 584, 623, 597));
        lineBorder.add(new Line(623, 597, 643, 612));
        lineBorder.add(new Line(643, 612, 767, 660));
        lineBorder.add(new Line(767, 659, 767, 664));
        lineBorder.add(new Line(767, 664, 556, 683));
        lineBorder.add(new Line(556, 683, 403, 683));
        lineBorder.add(new Line(403, 683, 266, 664));
        lineBorder.add(new Line(266, 664, 210, 640));
        lineBorder.add(new Line(210, 640, 152, 593));
        lineBorder.add(new Line(153, 592, 153, 547));
        lineBorder.add(new Line(151, 547, 160, 512));
        lineBorder.add(new Line(160, 512, 172, 501));
        lineBorder.add(new Line(172, 501, 207, 512));
        lineBorder.add(new Line(207, 512, 284, 560));
        lineBorder.add(new Line(284, 560, 343, 589));
        lineBorder.add(new Line(343, 589, 371, 588));
        lineBorder.add(new Line(371, 588, 395, 576));
        lineBorder.add(new Line(395, 576, 437, 520));
        lineBorder.add(new Line(437, 520, 484, 451));
        lineBorder.add(new Line(484, 451, 494, 422));
        lineBorder.add(new Line(494, 422, 490, 403));
        lineBorder.add(new Line(490, 403, 476, 394));
        lineBorder.add(new Line(475, 394, 426, 380));
        lineBorder.add(new Line(426, 380, 389, 372));
        lineBorder.add(new Line(389, 372, 343, 368));
        lineBorder.add(new Line(343, 368, 248, 349));
        lineBorder.add(new Line(249, 351, 198, 324));
        lineBorder.add(new Line(198, 324, 168, 287));
        lineBorder.add(new Line(168, 287, 150, 251));
    }

    private boolean collideBorder() {
        for(Line line:lineBorder){
            Point intersectLeft = findIntersect(line, plr.leftLine);
            Point intersectRight = findIntersect(line, plr.rightLine);
            Point intersectTop = findIntersect(line, plr.topLine);
            Point intersectBottom = findIntersect(line, plr.bottomLine);
            if(intersectLeft!=null && line.checkBound(intersectLeft) && plr.leftLine.checkBound(intersectLeft)) return true;
            if(intersectRight!=null && line.checkBound(intersectRight) && plr.rightLine.checkBound(intersectRight)) return true;
            if(intersectTop!=null && line.checkBound(intersectTop) && plr.topLine.checkBound(intersectTop)) return true;
            if(intersectBottom!=null && line.checkBound(intersectBottom) && plr.bottomLine.checkBound(intersectBottom)) return true;
        }
        return false;
    }

    public void update() {
        plr.update();
        if(collideBorder()){
            plr.reset();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bg, 0, 0, bg.getWidth(), bg.getHeight(), null);
        plr.draw(g2);
    }
}
