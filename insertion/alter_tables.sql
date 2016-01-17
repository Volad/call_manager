ALTER TABLE  callerphrase ALTER  COLUMN title TYPE varchar(1024);

ALTER TABLE  customerphrase  ALTER  COLUMN title TYPE varchar(1024);

ALTER TABLE  customerphrase  ALTER  COLUMN content TYPE varchar(1024);

ALTER TABLE  callerphrase ALTER  COLUMN id USING callerphrase_id_seq;

CREATE TABLE customer_answers_variants
(
  caller_phrase_id bigint NOT NULL,
  customer_phrase_id bigint NOT NULL,

  CONSTRAINT caller_phrase_id_customer_phrase_id UNIQUE (caller_phrase_id,customer_phrase_id),
  CONSTRAINT customer_answers_variants_caller_phrase FOREIGN KEY (caller_phrase_id)
  REFERENCES callerphrase (id) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT customer_answers_variants_customer_phrase FOREIGN KEY (customer_phrase_id)
  REFERENCES customerphrase (id) ON DELETE CASCADE ON UPDATE NO ACTION
)

CREATE TABLE caller_answers_variants
(
  customer_phrase_id bigint NOT NULL,
  caller_phrase_id  bigint NOT NULL,

  CONSTRAINT caller_answers_variants_unique UNIQUE (customer_phrase_id,caller_phrase_id),
  CONSTRAINT caller_answers_variants_caller_phrase FOREIGN KEY (caller_phrase_id)
  REFERENCES callerphrase (id) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT caller_answers_variants_customer_phrase FOREIGN KEY (customer_phrase_id)
  REFERENCES customerphrase (id) ON DELETE CASCADE ON UPDATE NO ACTION
)



INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (1, 2, true, 1, 'Добрый день! Это компания ....? Подскажите, с кем я могу пообщаться по снабжению?');

INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (2, 2, false, 1, 'Как я могу к Вам обращаться? Очень приятно, меня зовут Виктория, компания БелКреКомплект г.Борисов(пауза) Мы предлагаем Вам, широкую линейку(спокойно четко и внятно) крепежа, пен и герметиков, кровельных материалов, красок а так же строительный инструмент и расходники к нему. (пауза) Наверняка Вы что-то используете с этой тематики?');


INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (3, 2, false, 1, 'Замечательно! Расскажите по подробнее что вы закупаете по нашей тематике? (если чувствуете что человек в начале не особо вас слушал, повторяем чем занимаемся)');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (4, 2, false, 1, 'Подскажите когда я могу перезвонить?  С кем меня нужно соединить (Имя, должность)?  Спасибо!');

    INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (5, 2, false, 1, '(обращение по имени) Может сейчас есть потребность в каких-то позициях? Давайте я сейчас вам сделаю счет');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (6, 2, false, 1, 'Спасибо за заявку. В ближайшее время я выставлю вам счет. Куда вам будет удобнее отправить счет, на факс или на электронку? На случай если возникнут какие-то вопросы, могу я записать ваш мобильный(на крайняк рабочий) телефон.
После получения контактов - обращаемся по имени и благодарим еще раз, всего доброго'						
);

    INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (7, 2, false, 1, 'Подскажите когда мне лучше вам перезвонить, может быть у вас появится потребность?');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (8, 2, false, 1, 'Очень жаль(обращение по имени), что сегодня вы так категорично настроены. Я наберу вас в другой раз. До свиданья!');

    INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (9, 2, false, 1, '(обращение по имени) Спасибо! Я обязательно перезвоню вам, (ПОВТОРИТЬ) (в указанное клиентом время и дату))');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (10, 2, false, 1, 'Добрый день! Меня зовут Виктория, компания БелКрепКомплект г.Борисов. Извините, а Вас как зовут?  Очень приятно.Мы предлагаем Вам, широкую линейку(спокойно четко и внятно) крепежа, пен и герметиков, кровельных материалов, красок а так же строительный инструмент и расходники к нему. (пауза) Наверняка Вы что-то используете с этой тематики?');

INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (11, 2, false, 1, '(обращение по имени) Мы предлагаем вам те же (строй)материалы что вы закупаете сейчас, только дешевле. 
Практически все в наличии, а если чего-то нет - оперативно подвезем.  В перспективе Возможна отсрочка платежа, а при хороших заказах и бесплатная доставка. (пауза) Давайте попробуем?'						
);
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (12, 2, false, 1, 'Да используем... и рассказывает подробнее (слушаем)');

    INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (13, 2, false, 1, '(Обращение по имени)  Подскажите когда я могу Вам перезвонить?  Спасибо! Всего доброго!');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (14, 2, false, 1, '(Обращение по имени) Персонально для Вас, мы сделаем УСЛОВИЯ ЛУЧШЕ, чем вы имеете сейчас при работе с другой компанией...  Давайте поработаем?');

    INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (15, 2, false, 1, 'Не совсем понятна ваша позиция (Обращение по имени).  Можете пояснить причину отказа?');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (16, 2, false, 1, 'Ну вы же работаете и вам что-то поставляют, верно?');

    INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (17, 2, false, 1, 'Как  вы считаете, в течении какого времени сможете рассчитаться за первую поставку?');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (18, 2, false, 1, 'Очень жаль(обращение по имени), но к сожалению такой срок для нас не примелем. Искренне надеюсь что в ближайшей перспективе ситуация у вас улучшиться!  До свиданья!');

INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (19, 2, false, 1, '(Обращение по имени) Мы готовы пойти на встречу  и предоставить вам такую отсрочку платежа. Так (пауза) может сейчас есть потребность в каких-то материалах? Я выставлю вам счет для ознакомления!');
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (20, 2, false, 1, 'Я немедленно отправлю вам предложение. В какой день я могу вам перезвонить по поводу вашего решения? Спасибо за ваше время.');

INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (21, 2, false, 1, 'Очень жаль. Искренне надеемся что в ближайшей перспективе ситуация у вас улучшиться! Я наберу вас через месяц. До свиданья!');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (22, 2, false, 1, 'В таком случае позвольте отправить вам краткое предложение от нашей компании. Прошу вас, уделить ему минуту вашего внимания.');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (23, 2, false, 1, 'Я понял вашу позицию. Подскажите пожалуйста номер Вшего руководителя, я хочу удостоверится что он !!так же как и Вы, не желает получить более выгодные цены и условия по закупке стройматериалов.');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (24, 2, false, 1, 'Спасибо за ваше время. Всего доброго.');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (25, 2, false, 1, '(обращение по имени)Давайте я прямо сейчас отправлю вам коммерческое предложение. Вы рассмотрите и мы через несколько дней созвонимся?');
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (26, 2, false, 1, 'Отлично. В какой день я могу вам перезвонить по поводу вашего решения? Спасибо за ваше время. Всего доброго.');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (27, 2, false, 1, 'Замечательно! Расскажите по подробнее что вы закупаете по нашей тематике? (если чувствуете что человек в начале не особо вас слушал, повторяем чем занимаемся)');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (28, 2, false, 1, '(Обращение по имени) Персонально для Вас, мы сделаем УСЛОВИЯ ЛУЧШЕ, чем вы имеете сейчас при работе с другой компанией...  Давайте поработаем?');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (29, 2, false, 1, 'Не хочу отнимать ваше время, по-этому предлагаю сузить круг нашего предложения. Скажите чем занимается ваша компания?');
    
INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (30, 2, false, 1, 'В таком случая я перейду к сути. Мы предлагаем вам те же (строй)материалы что вы закупаете сейчас, только дешевле. 
Практически все в наличии, а если чего-то нет - оперативно подвезем.  В перспективе Возможна отсрочка платежа, а при хороших заказах и бесплатная доставка. (пауза) Давайте начнем работать!'						
);

INSERT INTO callerphrase(
            id, callerid, is_initial, "position", title)
    VALUES (31, 2, false, 1, '(Обращение по имени) Вы разве ничего не строите и не производите?'						
);

INSERT INTO customerphrase(id, content, title)
    VALUES ( 1 ,null, 'Со мной');
INSERT INTO customerphrase(id, content, title)
    VALUES (2, null, 'Сейчас никого нет');
INSERT INTO customerphrase(id, content, title)
    VALUES (3, null, 'Сейчас переключу');
INSERT INTO customerphrase(id, content, title)
    VALUES (4, null, 'Да используем');
INSERT INTO customerphrase(id, content, title)
    VALUES (5, null, 'Нет, не используем');
INSERT INTO customerphrase(id, content, title)
    VALUES (6, null, 'Сейчас ничего не нужно');
INSERT INTO customerphrase(id, content, title)
    VALUES (7, null, 'Нет времени(возможности) говорить');
INSERT INTO customerphrase(id, content, title)
    VALUES (8, null, 'Получили информацию');
INSERT INTO customerphrase(id, content, title)
    VALUES (9, null, 'Не получили информацию');
INSERT INTO customerphrase(id, content, title)
    VALUES (10, null, 'Получаем заявку и контактную информацию');
INSERT INTO customerphrase(id, content, title)
    VALUES (12, null, 'Агрессия');
INSERT INTO customerphrase(id, content, title)
    VALUES (13, null, 'Получили информацию когда перезвонить');
INSERT INTO customerphrase(id, content, title)
    VALUES (14, null, 'Я подумаю');
INSERT INTO customerphrase(id, content, title)
    VALUES (15, null, 'Да используем…  И рассказывает подробно');
INSERT INTO customerphrase(id, content, title)
    VALUES (16, null, 'Согласен');
INSERT INTO customerphrase(id, content, title)
    VALUES (17, null, 'Уже работаем с другой компанией');
INSERT INTO customerphrase(id, content, title)
    VALUES (18, null, 'Не понял или не услышал');
INSERT INTO customerphrase(id, content, title)
    VALUES (19, null, 'Нет, спасибо.');
INSERT INTO customerphrase(id, content, title)
    VALUES (20, null, 'Нет денег');
INSERT INTO customerphrase(id, content, title)
    VALUES (21, null, 'Работаем с другой компанией');
INSERT INTO customerphrase(id, content, title)
    VALUES (22, null, 'Да');
INSERT INTO customerphrase(id, content, title)
    VALUES (23, null, 'Нет');
INSERT INTO customerphrase(id, content, title)
    VALUES (24, null, 'Срок для нас НЕ приемлем');
INSERT INTO customerphrase(id, content, title)
    VALUES (25, null, 'Срок приемлем');
INSERT INTO customerphrase(id, content, title)
    VALUES (26, null, 'Получаем заявку и контактную информацию');
INSERT INTO customerphrase(id, content, title)
    VALUES (27, null, 'Я подумаю');
INSERT INTO customerphrase(id, content, title)
    VALUES (28, null, 'Получил контакты');
INSERT INTO customerphrase(id, content, title)
    VALUES (29, null, 'Не дал контакты или отшил');
INSERT INTO customerphrase(id, content, title)
    VALUES (30, null, 'Дал номер руководителя');
INSERT INTO customerphrase(id, content, title)
    VALUES (31, null, 'Не дал номер руководителя (грубость)');
INSERT INTO customerphrase(id, content, title)
    VALUES (32, null, 'Проявляет неуверенность');
INSERT INTO customerphrase(id, content, title)
    VALUES (33, null, 'Согласился');
INSERT INTO customerphrase(id, content, title)
    VALUES (34, null, 'Не согласился');
INSERT INTO customerphrase(id, content, title)
    VALUES (35, null, 'Отказ');
INSERT INTO customerphrase(id, content, title)
    VALUES (36, null, 'Любая сфера по нашей теме');
INSERT INTO customerphrase(id, content, title)
    VALUES (37, null, 'Да, давайте попробуем');
INSERT INTO customerphrase(id, content, title)
    VALUES (38, null, 'Нет. Звонок не по теме');
INSERT INTO customerphrase(id, content, title)
    VALUES (39, null, 'Сейчас ничего не нужно');
   
INSERT INTO customer_answers_variants(
            caller_phrase_id, customer_phrase_id)
    VALUES (1, 1),(1,2),(1,3),(2,4),(2,5),(2,39),(2,7),(2,15),(2,17),(2,18),(3,8),(3,9),(3,5),(5,10),(5,6),(7,12),(7,13),(10,6),(19,4),
    (10,14),(10,15),(11,12),(11,16),(12,8),(12,7),(14,19),(14,16),(14,27),(15,20),(15,21),(15,6),(16,22),(16,23),(17,24),(17,25),(19,26)
    ,(19,6),(22,20),(22,28),(22,29),(23,30),(23,31),(23,32),(25,33),(25,34),(27,8),(27,7),(28,35),(29,36),(29,8),(30,12),(30,37),(30,6),(30,7),(30,17),(31, 38);


INSERT INTO caller_answers_variants(customer_phrase_id,caller_phrase_id)  VALUES (1, 2),(4,3),(5,31),(6,4),(7,13),(8,5),(10,6),(39,7),(12,8)
	,(13,9),(14,11),(15,12),(16,5),(17,14),(18,29),(19,15),(20,16),(21,28),(22,17),(23,21),(24,18),(25,19),(26,20),(27,27),(29,21)
	,(30,24),(31,24),(32,25),(33,26),(34,24),(35,23),(36,30),(37,5),(2,4),(3,10);





        