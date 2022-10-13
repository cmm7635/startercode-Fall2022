from mrjob.job import MRJob

class Q2(MRJob):
  def mapper(self,key,line):
      self.cache = {}
      parts = line.split("\t")
      origin_airport = parts[3]
      origin_airport_2022 = parts[3]
      num_passengers = parts[7]
      num_passengers_2022 = parts[7]
      
      key = origin_airport
      value1 = (num_passengers)
      
      key = origin_airport_2022
      value2 = (num_passengers_2022)
      
      key = origin_airport
      value = ((value1 + value2), (value1 - value2))
      self.cache = {value}
      yield (key, value)
     
   def reducer(self, key, values):
          self.cache.delete(values)
          yield (key, (x,y))
 if __name__ = '__main__':
   Q2.run()
