from mrjob.job import MRJob

class Q1(MRJob):
  def mapper(self,key,line):
      parts = line.split()
      origin_airport = parts[3]
      origin_airport_2022 = parts[3]
      num_passengers = parts[7]
      
      key = origin_airport
      value1 = (num_passengers, "Outgoing)
      
      key = origin_airport_2022
      value2 = (num_passengers, "Outgoing")
      
      key = origin_airport
      value = ((value1 + value2), (value1 - value2))
      yield (key, value)
     
   def reducer(self, key, values):
          yield (key, (x,y))
 if __name__ = '__main__':
   Q1.run()
