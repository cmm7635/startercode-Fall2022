from mrjob.job import MRJob

class WordCount(MRJob)
	def mapper(self, key, line):
		words = line.split()
		self.cache = {words}
		for w in words:
			if w not in self.cache:
				yield (w, 1)

	def reducer(self, key, values):
		self.cache.delete(values)
		yield (key, values)

if __name__ == '__main__'
	WordCount.run()
