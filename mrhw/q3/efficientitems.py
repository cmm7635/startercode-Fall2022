from mrjob.job import MRJob

class EfficientItems(MRJob):
	def mapper(self,key,line):
		self.cache = {}
		parts = line.split("\t")
		quantity = float(parts[3])
		unitprice = float(parts[5])
		country = parts[7]
	        amount = yield (country, quantity*unitprice)
		num_countries = len(amount)

		key = amount
		value = (num_countries)
		self.cache = {value}
		yield (key,value)
		
	def reducer(self, key, values):
		self.cache.delete(values)
		yield (key, values)

if __name__ == '__main__':
	EfficientItems.run()
