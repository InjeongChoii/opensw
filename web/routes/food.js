var express = require('express');
var db = require('../db')
var router = express.Router();

//food/:name
router.get('/:name',function(req, res, next){
  var name = req.params.name;

  var sql = "select * " +
            "from refrigerator_food " +
            "where name = ? limit 1;";
  console.log("sql : " + sql);

  db.get().query(sql, name, function(err, rows){
    console.log("rows : " +JSON.stringify(rows));
    console.log("row.length : " + rows.length);
    if(rows.length > 0){
      res.json(rows[0]);
    }else{
      res.sendStatus(400);
    }
  });
});


//member/info
router.post('/info', function(req, res, next){
  if(!req.params.mem_seq){
    return res.sendStatus(400);
  }

  var mem_seq = req.params.mem_seq;
  var name = req.params.name;
  var category = req.params.category;

  var sql_insert = "insert into refrigerator_food (mem_seq, name, category) values(?, ?, ?);";
  console.log(sql_insert);

  var params = [mem_seq, name, category];

  db.get().query(sql_insert,params, function(err, result){
    console.log(result.insertID);
    res.status(200).send('' + result.insertID);
  });
});

module.exports = router;
