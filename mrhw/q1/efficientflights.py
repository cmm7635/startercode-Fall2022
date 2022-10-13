from mrjob.job import MRJob

class EfficientFlights(MRJob):
	def mapper(self,key,line):
		self.cache = {}
		parts = line.split("\t")
		origin_airport = parts[3]
		destination_airport = parts[4]
		num_passengers = parts[6]

		key = origin_airport
		value = (num_passengers, "Outgoing")
		self.cache = {value}
		yield (key, value)
		
		key = destination_state
		value = (num_passengers, "Incoming")
		self.cache = {value}
		yield (key, value)

	def reducer(self, key, values):
		self.cache.delete(values)
		yield (key, (x,y))

if __name__ == '__main__':
	EfficientFlights.run()
