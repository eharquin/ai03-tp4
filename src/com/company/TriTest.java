package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriTest {

    @Test
    @DisplayName("Est trié")
    void estTrie() {
        Tri tri = new Tri();
        int val[] = {2};
        int val2[] = {1, 2};
        int val3[] = {3, 2};
        int val4[] = {1, 2, 3, 4};
        int val5[] = {1, 2, 5, 4};
        int val6[] = {-1, 2, 5, 8, 9, 10};
        int val7[] = {};
        int val8[] = {10, 2, 3, 4, 5, 6};
        assertAll(() -> assertTrue(tri.estTrie(val)),
                () -> assertTrue(tri.estTrie(val2)),
                () -> assertFalse(tri.estTrie(val3)),
                () -> assertTrue(tri.estTrie(val4)),
                () -> assertFalse(tri.estTrie(val5)),
                () -> assertTrue(tri.estTrie(val6)),
                () -> assertTrue(tri.estTrie(val7)),
                () -> assertFalse(tri.estTrie(val8)));
    }

    @Test
    @DisplayName("Tri à bulles optimisé")
    void triBulleOptimise() {
        Tri tri = new Tri();
        int val[] = {1, 2, 3};
        int val2[] = {5, 8, 1, 7, 2};
        int val3[] = {};
        int val4[] = {110, -20, 5, 8, 10, -6, -20};
        int val5[] = {5, 4, 3, 2, 1, 0};
        tri.triBulleOptimise(val);
        tri.triBulleOptimise(val2);
        tri.triBulleOptimise(val3);
        tri.triBulleOptimise(val4);
        tri.triBulleOptimise(val5);
        assertAll(() -> assertArrayEquals(new int[]{1, 2, 3}, val),
        () -> assertArrayEquals(new int[]{1, 2, 5, 7, 8}, val2),
        () -> assertArrayEquals(new int[]{}, val3),
        () -> assertArrayEquals(new int[] {-20, -20, -6, 5, 8, 10, 110}, val4),
        () -> assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5}, val5));
    }
    @Test
    @DisplayName("Tri par sélection")
    void triSelection() {
        Tri tri = new Tri();
        int val[] = {1, 2, 3};
        int val2[] = {5, 8, 1, 7, 2};
        int val3[] = {};
        int val4[] = {110, -20, 5, 8, 10, -6, -20};
        int val5[] = {5, 4, 3, 2, 1, 0};
        tri.triSelection(val);
        tri.triSelection(val2);
        tri.triSelection(val3);
        tri.triSelection(val4);
        tri.triSelection(val5);
        assertAll(() -> assertArrayEquals(new int[]{1, 2, 3}, val),
                () -> assertArrayEquals(new int[]{1, 2, 5, 7, 8}, val2),
                () -> assertArrayEquals(new int[]{}, val3),
                () -> assertArrayEquals(new int[] {-20, -20, -6, 5, 8, 10, 110}, val4),
                () -> assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5}, val5));
    }
    @Test
    @DisplayName("Echanger")
    void echanger() {
        int val[] = {2, 8, 6};
        int val2[] = {2, 8, 5, 6};
        int val3[] = {2};
        int val4[] = {6, 4, 7};

        Tri tri = new Tri();
        int arrayTesting[] = val.clone();
        tri.echanger(arrayTesting, 1, 2);
        assertArrayEquals(new int[]{2, 6, 8}, arrayTesting);

        tri.echanger(val3, 0, 0);
        assertArrayEquals(new int[]{2}, val3);

        arrayTesting = val4.clone();
        tri.echanger(arrayTesting, 0, 1);
        assertArrayEquals(new int[]{4, 6, 7}, arrayTesting);

        arrayTesting = val2.clone();
        tri.echanger(arrayTesting, -1, 5);
        assertArrayEquals(val2, arrayTesting);

        arrayTesting = val2.clone();
        tri.echanger(arrayTesting, 2, -1);
        assertArrayEquals(val2, arrayTesting);
    }
}