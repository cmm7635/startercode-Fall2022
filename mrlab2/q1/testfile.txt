from mrjob.job import MRJob

class Orders(MRJob):
    def mapper(self,key,line):
        words = line.split():
	for w in words:
            sum = 0
            if isinstance(w,int):
                sum = w + sum
            else:
                w = w
	    yield (w,sum) 

    def reducer(self, key, values):
	yield (key, sum(values)

if __name__ == '__main__':
     Orders.run()
