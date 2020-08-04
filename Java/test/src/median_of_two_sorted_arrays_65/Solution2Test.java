package test.src.median_of_two_sorted_arrays_65;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.median_of_two_sorted_arrays_65.Solution2;
import src.utils.TestUtil;

/**
 * Solution2 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>8月 4, 2020</pre>
 */
public class Solution2Test {

    private Solution2 solution;

    @Before
    public void before() throws Exception {
        solution = new Solution2();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findMedianSortedArrays(int[] A, int[] B)
     */
    @Test
    public void testFindMedianSortedArrays() throws Exception {
        TestCase.assertEquals(1.0, solution.findMedianSortedArrays(
                TestUtil.buildIntArray(),
                TestUtil.buildIntArray(1)
        ));

        TestCase.assertEquals(3.5, solution.findMedianSortedArrays(
                TestUtil.buildIntArray(1, 2, 3, 4, 5, 6),
                TestUtil.buildIntArray(2, 3, 4, 5)
        ));

        TestCase.assertEquals(3.0, solution.findMedianSortedArrays(
                TestUtil.buildIntArray(1, 2, 3),
                TestUtil.buildIntArray(4, 5)
        ));

        TestCase.assertEquals(4.0, solution.findMedianSortedArrays(
                TestUtil.buildIntArray(1, 2, 3, 4),
                TestUtil.buildIntArray(4, 5, 6, 7, 8)
        ));

        TestCase.assertEquals(3.0, solution.findMedianSortedArrays(
                TestUtil.buildIntArray(1),
                TestUtil.buildIntArray(2, 3, 4, 5)
        ));

        TestCase.assertEquals(3.5, solution.findMedianSortedArrays(
                TestUtil.buildIntArray(),
                TestUtil.buildIntArray(2, 3, 4, 5)
        ));

        TestCase.assertEquals(542.0, solution.findMedianSortedArrays(
                TestUtil.buildIntArray(1, 1, 14, 31, 33, 40, 42, 66, 71, 74, 113, 117, 124, 125, 127, 137, 143, 184, 187, 188, 221, 222, 224, 248, 251, 269, 293, 294, 315, 324, 330, 353, 358, 366, 368, 389, 389, 408, 424, 432, 433, 451, 452, 456, 459, 475, 480, 483, 484, 496, 509, 515, 519, 523, 559, 567, 568, 593, 598, 600, 612, 623, 626, 628, 632, 633, 634, 646, 654, 663, 681, 696, 706, 709, 717, 723, 746, 753, 790, 790, 798, 824, 826, 847, 849, 857, 866, 879, 882, 894, 894, 913, 925, 938, 942, 961, 974, 988, 988, 989, 998),
                TestUtil.buildIntArray(3, 4, 5, 6, 9, 15, 17, 20, 21, 21, 23, 25, 27, 27, 28, 29, 31, 32, 37, 41, 43, 47, 49, 50, 52, 52, 52, 54, 59, 60, 67, 68, 71, 72, 73, 77, 78, 84, 86, 88, 88, 91, 94, 98, 98, 98, 100, 102, 105, 106, 107, 107, 110, 117, 118, 120, 122, 124, 126, 129, 131, 134, 135, 144, 147, 154, 158, 158, 163, 164, 164, 170, 171, 171, 172, 172, 176, 178, 180, 183, 184, 185, 189, 196, 197, 199, 200, 200, 204, 208, 214, 217, 223, 226, 227, 231, 231, 232, 232, 237, 243, 244, 245, 251, 258, 259, 266, 271, 274, 277, 279, 280, 280, 281, 283, 284, 284, 284, 286, 288, 290, 296, 299, 301, 302, 302, 302, 303, 305, 308, 308, 309, 311, 313, 313, 316, 322, 323, 326, 327, 328, 329, 331, 331, 337, 340, 340, 342, 343, 345, 346, 349, 349, 349, 350, 354, 366, 366, 375, 376, 377, 377, 379, 382, 389, 390, 391, 392, 393, 394, 397, 397, 397, 399, 400, 400, 402, 402, 403, 404, 405, 405, 408, 414, 415, 416, 416, 416, 419, 421, 422, 426, 426, 427, 430, 432, 433, 436, 440, 443, 445, 448, 448, 454, 455, 456, 456, 457, 458, 459, 459, 462, 465, 466, 467, 471, 475, 493, 500, 501, 505, 507, 509, 511, 512, 512, 513, 513, 514, 514, 515, 516, 517, 518, 520, 521, 523, 524, 525, 528, 533, 535, 535, 536, 537, 539, 542, 542, 544, 545, 547, 551, 552, 553, 554, 554, 556, 557, 557, 558, 559, 559, 561, 563, 565, 568, 570, 578, 578, 579, 580, 580, 581, 581, 588, 590, 591, 592, 592, 593, 594, 595, 597, 601, 603, 603, 605, 607, 610, 611, 612, 612, 612, 614, 617, 620, 621, 622, 622, 624, 624, 625, 625, 627, 627, 627, 632, 635, 635, 637, 638, 642, 644, 644, 647, 647, 650, 651, 652, 653, 654, 655, 657, 660, 664, 667, 670, 671, 672, 673, 673, 676, 677, 682, 685, 685, 686, 686, 688, 694, 695, 695, 697, 699, 700, 700, 704, 704, 707, 709, 713, 713, 715, 716, 716, 717, 719, 721, 725, 732, 736, 740, 742, 745, 746, 749, 752, 754, 755, 756, 756, 757, 760, 762, 763, 765, 766, 768, 768, 768, 772, 774, 775, 775, 780, 784, 784, 785, 785, 788, 790, 791, 792, 794, 796, 796, 798, 800, 802, 802, 804, 806, 806, 808, 813, 814, 816, 817, 817, 818, 824, 824, 825, 825, 827, 830, 832, 834, 834, 837, 841, 842, 843, 845, 846, 848, 852, 855, 855, 855, 860, 861, 866, 866, 872, 874, 875, 875, 877, 883, 886, 892, 892, 895, 895, 897, 898, 898, 900, 900, 900, 904, 904, 905, 906, 907, 909, 909, 914, 914, 914, 915, 922, 924, 927, 928, 930, 931, 936, 938, 939, 941, 944, 945, 946, 947, 948, 950, 955, 956, 960, 961, 967, 967, 969, 971, 972, 978, 979, 981, 982, 984, 984, 989, 990, 993, 997, 999, 999, 1001)
        ));

        TestCase.assertEquals(57374323.0, solution.findMedianSortedArrays(
                TestUtil.buildIntArray(1,3),
                TestUtil.buildIntArray(114748643,1147483644)
        ));
    }


}
