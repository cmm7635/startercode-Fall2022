
from mrjob.job import MRJob

class efficientFBCount(MRJob)
	def mapper(self, key, line):
		self.cache = {}
		(left, right) = line.split(" ")
		if int(right) > 500:
			yield(left, 1)
		self.cache = {line}
		yield(key, line)

	def reducer(self, key, values):
		left = key
		myval = sum(values)
		if myval > 2:
			yield (left, myval+1)
		self.cache.delete
		yield(key, values)

if  __name__ == '__main__':
	efficientFBCount.run 
