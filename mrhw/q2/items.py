from mrjob.job import MRJob

class Items(MRJob):
	def mapper(self,key,line):
		parts = line.split("\t")
		quantity = float(parts[3])
		unitprice = float(parts[5])
		country = parts[7]
	        amount = yield (country, quantity*unitprice)
		num_countries = len(amount)
		
	def reducer(self, key, values):
		yield (key, values)

if __name__ == '__main__':
	Items.run()
