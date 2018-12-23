# TODO

* Move config save out of JobProcessor.
* Move Park at End out of JobProcessor.
* Move stats out of JobProcessor.
* Reconsider Signaler coupling with JobProcessor.

# CHMT Notes

CHMT does:
1. Feed
2. Pick
3. Vacuum Check
	If this fails, it goes goes back to Pick, 2 times. 
	If it continues to fail, it goes back to Feed, 3 times.
	If it continues to fail, it finally throws an error.
	So maybe each step gets an attempt count.
	Or maybe this is all one function? I think it actually is.
	
If it errors it throws an alarm and stops the job completely. To restart you have to enter the
component number you want to restart at and basically start the job again.	
	
	
# New Ideas
	
* Consider what we currently think of as placements as different types of objects. There's
  placements, fiducials, maybe glue points, maybe solder points, maybe even test points.
	
  These could maybe each be in their own tab, or just combined in the list with a dropdown to select
  what you are viewing.

  This would make it easier to know which editors (property sheets) to show for each thing.
  
  I really like this idea. For glue points you could select your dispenser and whatever settings
  are require for that point. For a fiducial you are setting the shape - get rid of the package
  stuff. For a placement you are selecting the part, alignment, etc.
  
  Maybe in the "All" tab everythign is in the list the way it will happen in the job. Fids are
  listed first, then placements and glue and those can be rearranged and then this becomes the
  job status when running while the rest are disabled.
  
  	
* Alignment should maybe be selectable on a per part basis. So, for instance, for all your
  resistors you could select "None", for most parts you use "Simple" which doesn't use a pipeline
  and then you could also select "Pipeline".	
