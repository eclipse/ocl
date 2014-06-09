#*******************************************************************************
# Copyright (c) 2013 E.D.Willink and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     E.D.Willink - initial API and implementation
#*******************************************************************************
#!/bin/bash

mv buildroot/buckminster.output/org.eclipse.ocl.releng.build_*-eclipse.feature/site.p2 MDT-OCL.p2.repository
mv buildroot/buckminster.output/org.eclipse.ocl.releng.build_*-eclipse.feature/zips MDT-OCL.downloads

/opt/public/common/apache-ant-1.8.1/bin/ant -f publishroot/publisher.ant -Dbuild.archives=${WORKSPACE} 

if [ ${MANAGE_JAVADOC} = "true" ]
then
  mkdir MDT-OCL.javadoc
  mv buildroot/buckminster.output/org.eclipse.ocl.releng.buckminster_*-buckminster/javadoc/MDT-OCL-javadoc.zip MDT-OCL.javadoc/MDT-OCL-javadoc.zip
  rm -rf buildroot/buckminster.output/org.eclipse.ocl.releng.buckminster_*-buckminster/javadoc
fi

if [ ${PUBLISH_DOC} = "true" ]
then
  mkdir MDT-OCL.doc
  cp org.eclipse.ocl.git/doc/org.eclipse.ocl.doc/manual/ocl.pdf MDT-OCL.doc
fi
