import re

input_str = "a bb cc-c--d"

pattern = r"[a-zA-Z-]+"

pattern2 = r"-{2,}"

all_matches = re.findall(pattern, input_str)

for i, s in enumerate(all_matches):
    all_matches[i] = re.split(pattern2, s)

all_matches = [i for k in all_matches for i in k]

print (all_matches[::-1])

# for i in 
        
        

# for i in all_matches:

