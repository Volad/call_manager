
/**
 * 
 */
package com.cm.db.creator.user;

import com.cm.entity.CustomerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public class CustomerPhraseCreator {
    public static CustomerPhrase create() {
        return CustomerPhraseCreator.create("Test Content", "Test title");
    }

    public static CustomerPhrase create(String content, String title) {
        CustomerPhrase customerPhrase = new CustomerPhrase();
        customerPhrase.setContent(content);
        customerPhrase.setTitle(title);
        return customerPhrase;

    }
}
