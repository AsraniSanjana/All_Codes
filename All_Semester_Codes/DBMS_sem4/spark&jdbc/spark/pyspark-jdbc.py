from pyspark.sql import SparkSession

# Initialize SparkSession
spark = SparkSession.builder \
    .appName("MySQL JDBC Connection") \
    .config("spark.jars", "/path/to/mysql-connector-java.jar") \
    .getOrCreate()

# Define MySQL connection properties
mysql_url = "jdbc:mysql://localhost:3306/hostel_ms"
mysql_properties = {
    "user": "root",
    "password": "",
    "driver": "com.mysql.jdbc.Driver"
}

# Read data from MySQL table
mysql_table_name = "student"
df = spark.read.jdbc(url=mysql_url, table=mysql_table_name, properties=mysql_properties)

# Show DataFrame
df.show()

# Stop SparkSession
spark.stop()
