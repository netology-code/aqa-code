const express = require('express');
const app = express();
const port = 9999;

const data = [ 
    { 
       'id':1,
       'name':'Альфа-Карта Premium',
       'description':'Альфа-Карта вернёт ваши деньги',
       'imageUrl':'/alfa-card-premium.png'
    },
    { 
       'id':2,
       'name':'Alfa Travel Premium',
       'description':'Самая выгодная карта для путешествий',
       'imageUrl':'/alfa-card-travel.png'
    },
    { 
       'id':3,
       'name':'CashBack Premium',
       'description':'Заправь свою карту. Кэшбэк на АЗС, в кафе и ресторанах',
       'imageUrl':'/alfa-card-cashback.png'
    }
];

app.get('/api/cards', (req, res) => res.send(data));

app.listen(port);
