import mysql.connector

class DBConnectionWrapper():
    def __init__(self):
        self.mydb = mysql.connector.connect(
        host = "localhost",
        user = "root",
        password = "1234",
        database = "python_db"
    )
        
    def cursor(self):
        return self.mydb.cursor()
    
    def commit(self):
        self.mydb.commit()
