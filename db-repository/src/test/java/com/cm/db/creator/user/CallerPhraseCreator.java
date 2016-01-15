
/**
 * 
 */
package com.cm.db.creator.user;

import com.cm.entity.CallerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public class CallerPhraseCreator {
    public static CallerPhrase create() {
        return CallerPhraseCreator.create(2l, "Test Caller phrase title", 1, false);
    }

    public static CallerPhrase create(Long callerId, String title, int position, boolean isInitial) {
        CallerPhrase callerPhrase = new CallerPhrase();
        callerPhrase.setTitle(title);
        callerPhrase.setCallerId(callerId);
        callerPhrase.setPosition(position);
        callerPhrase.setInitial(isInitial);
        return callerPhrase;

    }
}
