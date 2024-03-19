package model;

import data.model.Diary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;


class DiaryTest {

   @Test
  public void unLockDiary() {
       Diary diary = new Diary("Onome","1234");
       diary.unLockDiary();
       assertTrue(diary.unLockDiary());
    }

  @Test
   public void lockDiary() {
       Diary diary = new Diary("Onome", "1234");
       diary.unLockDiary();

    }

    @Test
    public void testThatDiary_isLocked() {
        Diary diary = new Diary("Onome", "1234");
        assertTrue(diary.lockDiary());
    }


    @Test
    public void testThatDiary_canBeLocked() {
        Diary diary = new Diary("Onome", "1234");
        assertTrue(diary.unLockDiary());
        diary.lockDiary();
        assertFalse(diary.isLocked());
    }
}
